package io.swagger.mapper;

import io.swagger.Exception.ApiException;
import io.swagger.geocode.AddressConverter;
import io.swagger.model.*;
import io.swagger.repository.GarageDao;
import io.swagger.repository.UserDao;
import io.swagger.repository.specification.GarageSpecification;
import io.swagger.repository.specification.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GarageMapper {

    @Autowired
    private GarageDao garageDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private AddressConverter addressConverter;

    public GarageMapper() {
    }

    public Garage createGarage(Garage body) throws Exception {
        if ((userDao.existsById(body.getIdPartner())) && (userDao.findById(body.getIdPartner())).get().getStatus().equals(User.StatusEnum.PARTNER)) {
            try {
                body.setId(null);
                body.getAddress().setId(null);
                if (body.getComments() != null && !(body.getComments().isEmpty())) {
                    for (Comment comment : body.getComments()) {
                        comment.setId(null);
                    }
                }
                garageDao.save(addressConverter.convertGarageAddress(body));
                return body;
            } catch (Exception e) {
                throw new ApiException((400), e.getMessage());
            }
        } else throw new ApiException(404, "partner not exists");
    }


    public void deleteGarageById(Integer id) throws ApiException {
        if (garageDao.existsById(id)) {
            garageDao.deleteById(id);
        } else throw new ApiException(404, "Garage not found");
    }

    public InlineResponse200 getGarage(@Valid String searchByName, @Valid Integer searchByPartner, @Valid String searchByAdress) {
        GarageSpecification spec2 = null;
        InlineResponse200 inlineResponse200 = new InlineResponse200();
        List<Garage> newList = new ArrayList<>();
        if (searchByName != null) {
            List<Garage> list = garageDao.findAll();
            for (Garage garage : list) {
                if (garage.getName().toUpperCase().contains(searchByName.toUpperCase())) {
                    newList.add(garage);
                }
            }
            inlineResponse200.setData(newList);
            return inlineResponse200;
        }
        if (searchByPartner != null) {
            spec2 = new GarageSpecification(new SearchCriteria("idPartner", ":", searchByPartner));
        }
        if (searchByAdress != null) {
            inlineResponse200.setData(addressConverter.findNearby(searchByAdress));
            return inlineResponse200;
        }
        inlineResponse200.setData(garageDao.findAll(Specification.where(spec2)));
        return inlineResponse200;
    }

    public InlineResponse2001 getGarageById(Integer id) throws ApiException {
        if (garageDao.existsById(id)) {
            Optional<Garage> garage = garageDao.findById(id);
            InlineResponse2001 inlineResponse2001 = new InlineResponse2001();
            garage.ifPresent(inlineResponse2001::setData);
            return inlineResponse2001;
        } else throw new ApiException(404, "Garage not Found");
    }

    public Garage updateGarageById(Integer id, @Valid Garage body) throws Exception {
        if (id.equals((body.getId())) && garageDao.existsById(id)) {
            Optional<Garage> garage = garageDao.findById(id);
            if (garage.isPresent() && !(garage.get().getAddress().equals(body.getAddress()))) {
                body = addressConverter.convertGarageAddress(body);
            }
            for (Comment comment : body.getComments()) {
                if (!(garage.get().getComments().contains(comment))) {
                    comment.setId(null);
                }
            }
            garageDao.save(body);
            garage = garageDao.findById(id);
            if (garage.isPresent()) {
                return garage.get();
            } else throw new ApiException(400, "Bad request");
        } else throw new ApiException(404, "Garage not found");
    }
}

