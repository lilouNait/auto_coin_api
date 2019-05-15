package io.swagger.mapper;

import io.swagger.Exception.ApiException;
import io.swagger.model.Garage;
import io.swagger.model.InlineResponse200;
import io.swagger.repository.GarageDao;
import io.swagger.repository.specification.GarageSpecification;
import io.swagger.repository.specification.SearchCriteria;
import io.swagger.repository.specification.UserSpecification;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import javax.validation.Valid;

public class GarageMapper {

    @Autowired
    private GarageDao garageDao;

    public GarageMapper(){
    }
    public Garage createGarage(Garage body) throws Exception{
        try {
            garageDao.save(body);
            return body;
        }catch (Exception e){
            throw new ApiException((400),e.getMessage());
        }
    }
    public void deleteGarageById(Integer id) throws ApiException{
        if (garageDao.existsById(id)){
            garageDao.deleteById(id);
        }
        throw new ApiException(400,"Garage not found");
    }

    public InlineResponse200 getGarage(@Valid String searchByName, @Valid String searchByPartner,@Valid String searchByAdress, @Valid String searchByCoordinates){
        GarageSpecification spec1=null;
        GarageSpecification spec2=null;
        GarageSpecification spec3=null;
        GarageSpecification spec4=null;
        if (searchByName != null){
            spec1 = new GarageSpecification(new SearchCriteria("name",":",searchByName));
        }
        if (searchByPartner != null){
            spec2 = new GarageSpecification(new SearchCriteria( "partner",":", searchByPartner));
        }
        if (searchByAdress != null){
            spec3=new GarageSpecification(new SearchCriteria("",":",searchByAdress));
        }
        if (searchByCoordinates != null){
            spec4=new GarageSpecification(new SearchCriteria("",":",searchByCoordinates));
        }
        InlineResponse200 inlineResponse200 = new InlineResponse200();
        inlineResponse200.setData(garageDao.findAll(org.springframework.data.jpa.domain.Specification.where(spec1).and(spec2).and(spec3).and(spec4)));
        return inlineResponse200;
    }
    public Garage getGarageById(){
        return null;
    }
}