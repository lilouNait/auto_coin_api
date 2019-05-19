package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.Exception.ApiException;
import io.swagger.annotations.ApiParam;
import io.swagger.mapper.GarageMapper;
import io.swagger.model.Garage;
import io.swagger.model.InlineResponse200;
import io.swagger.model.InlineResponse2001;
import io.swagger.repository.GarageDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-09T18:50:43.350+02:00")

@Controller
public class GaragesApiController implements GaragesApi {

    private GarageMapper garageMapper;
    private static final Logger log = LoggerFactory.getLogger(GaragesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public GaragesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Garage> createGarage(@ApiParam(value = "Garage to be created.", required = true) @Valid @RequestBody Garage body) throws Exception {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<Garage>(garageMapper.createGarage(body), HttpStatus.CREATED);
        } else return new ResponseEntity<Garage>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Void> deleteGarageById(@ApiParam(value = "Unique garage identifier.", required = true) @PathVariable("id") Integer id) throws ApiException {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")){
            garageMapper.deleteGarageById(id);
            return  new ResponseEntity<Void>(HttpStatus.OK);
        }else return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<InlineResponse200> getGarage(@ApiParam(value = "Search by name.") @Valid @RequestParam(value = "Search by name", required = false) String searchByName, @ApiParam(value = "Search by partner.") @Valid @RequestParam(value = "partner", required = false) String partner, @ApiParam(value = "Search by address.") @Valid @RequestParam(value = "address", required = false) String address, @ApiParam(value = "Search by coordinates.") @Valid @RequestParam(value = "coordinates", required = false) String coordinates) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<InlineResponse200>(garageMapper.getGarage(searchByName,partner,address,coordinates),HttpStatus.OK);
        } else{
            return new ResponseEntity<InlineResponse200>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<InlineResponse2001> getGarageById(@ApiParam(value = "Unique garage identifier.", required = true) @PathVariable("id") Integer id) throws ApiException
        {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")){
                return new ResponseEntity<InlineResponse2001>( garageMapper.getGarageById(id),HttpStatus.OK);
            }else{
                return new ResponseEntity<InlineResponse2001>(HttpStatus.BAD_REQUEST);
            }
        }

    public ResponseEntity<Garage> updateGarageById(@ApiParam(value = "Unique garage identifier.", required = true) @PathVariable("id") Integer id, @ApiParam(value = "Garage data to be updated", required = true) @Valid @RequestBody Garage body) throws Exception {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")){
                return new ResponseEntity<Garage>(garageMapper.updateGarageById(id, body), HttpStatus.OK);
            } else return new ResponseEntity<Garage>(HttpStatus.BAD_REQUEST);
    }
}
