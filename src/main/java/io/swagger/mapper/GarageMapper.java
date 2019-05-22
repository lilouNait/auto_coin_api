package io.swagger.mapper;

import cucumber.api.java.cs.A;
import io.swagger.Exception.ApiException;
import io.swagger.model.Garage;
import io.swagger.model.InlineResponse200;
import io.swagger.model.InlineResponse2001;
import io.swagger.model.InlineResponse2003;
import io.swagger.repository.GarageDao;
import io.swagger.repository.UserDao;
import io.swagger.repository.specification.GarageSpecification;
import io.swagger.repository.specification.SearchCriteria;
import io.swagger.repository.specification.UserSpecification;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.Valid;
import java.util.Optional;

public class GarageMapper {

    @Autowired
    private GarageDao garageDao;
    @Autowired
    private UserDao userDao;

    public GarageMapper() {
    }

    public Garage createGarage(Garage body) throws Exception {
        try {
            body.setId(null);
            garageDao.save(body);
            return body;
        } catch (Exception e) {
            throw new ApiException((400), e.getMessage());
        }
    }

    public void deleteGarageById(Integer id) throws ApiException {
        if (garageDao.existsById(id)) {
            garageDao.deleteById(id);
        }
        throw new ApiException(404, "Garage not found");
    }

    public InlineResponse200 getGarage(@Valid String searchByName, @Valid String searchByPartner, @Valid String searchByAdress, @Valid String searchByCoordinates) {
        GarageSpecification spec1 = null;
        GarageSpecification spec2 = null;
        GarageSpecification spec3 = null;
        GarageSpecification spec4 = null;
        if (searchByName != null) {
            spec1 = new GarageSpecification(new SearchCriteria("name", ":", searchByName));
        }
        if (searchByPartner != null) {
            spec2 = new GarageSpecification(new SearchCriteria("partner", ":", searchByPartner));
        }
        if (searchByAdress != null) {
            spec3 = new GarageSpecification(new SearchCriteria("", ":", searchByAdress));
        }
        if (searchByCoordinates != null) {
            spec4 = new GarageSpecification(new SearchCriteria("", ":", searchByCoordinates));
        }
        InlineResponse200 inlineResponse200 = new InlineResponse200();
        inlineResponse200.setData(garageDao.findAll(org.springframework.data.jpa.domain.Specification.where(spec1).and(spec2).and(spec3).and(spec4)));
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
            garageDao.save(body);
            garage = garageDao.findById(id);
            if (garage.isPresent()) {
                return garage.get();
            } else throw new ApiException(400, "Bad request");
        } else throw new ApiException(404, "Garage not found");
    }
}
