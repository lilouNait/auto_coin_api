package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Garage;
import io.swagger.model.InlineResponse200;
import io.swagger.model.InlineResponse2001;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-09T18:50:43.350+02:00")

@Controller
public class GaragesApiController implements GaragesApi {

    private static final Logger log = LoggerFactory.getLogger(GaragesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public GaragesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Garage> createGarage(@ApiParam(value = "Garage to be created.", required = true) @Valid @RequestBody Garage body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Garage>(objectMapper.readValue("{  \"id_partner\" : 6,  \"address\" : {    \"country\" : \"country\",    \"address\" : \"address\",    \"city\" : \"city\",    \"id\" : 1  },  \"comments\" : [ {    \"note\" : 2,    \"comment\" : \"comment\",    \"id\" : 5,    \"client_id\" : 5  }, {    \"note\" : 2,    \"comment\" : \"comment\",    \"id\" : 5,    \"client_id\" : 5  } ],  \"partner\" : \"partner\",  \"phone\" : \"phone\",  \"name\" : \"name\",  \"coordinates\" : [ \"coordinates\", \"coordinates\" ],  \"description\" : \"description\",  \"id\" : 0}", Garage.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Garage>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Garage>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteGarageById(@ApiParam(value = "Unique garage identifier.", required = true) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse200> getGarage(@ApiParam(value = "Search by name.") @Valid @RequestParam(value = "Search by name", required = false) String searchByName, @ApiParam(value = "Search by partner.") @Valid @RequestParam(value = "partner", required = false) String partner, @ApiParam(value = "Search by address.") @Valid @RequestParam(value = "address", required = false) String address, @ApiParam(value = "Search by coordinates.") @Valid @RequestParam(value = "coordinates", required = false) String coordinates) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse200>(objectMapper.readValue("{  \"data\" : [ {    \"id_partner\" : 6,    \"address\" : {      \"country\" : \"country\",      \"address\" : \"address\",      \"city\" : \"city\",      \"id\" : 1    },    \"comments\" : [ {      \"note\" : 2,      \"comment\" : \"comment\",      \"id\" : 5,      \"client_id\" : 5    }, {      \"note\" : 2,      \"comment\" : \"comment\",      \"id\" : 5,      \"client_id\" : 5    } ],    \"partner\" : \"partner\",    \"phone\" : \"phone\",    \"name\" : \"name\",    \"coordinates\" : [ \"coordinates\", \"coordinates\" ],    \"description\" : \"description\",    \"id\" : 0  }, {    \"id_partner\" : 6,    \"address\" : {      \"country\" : \"country\",      \"address\" : \"address\",      \"city\" : \"city\",      \"id\" : 1    },    \"comments\" : [ {      \"note\" : 2,      \"comment\" : \"comment\",      \"id\" : 5,      \"client_id\" : 5    }, {      \"note\" : 2,      \"comment\" : \"comment\",      \"id\" : 5,      \"client_id\" : 5    } ],    \"partner\" : \"partner\",    \"phone\" : \"phone\",    \"name\" : \"name\",    \"coordinates\" : [ \"coordinates\", \"coordinates\" ],    \"description\" : \"description\",    \"id\" : 0  } ]}", InlineResponse200.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse200>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse200>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse2001> getGarageById(@ApiParam(value = "Unique garage identifier.", required = true) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse2001>(objectMapper.readValue("{  \"data\" : {    \"id_partner\" : 6,    \"address\" : {      \"country\" : \"country\",      \"address\" : \"address\",      \"city\" : \"city\",      \"id\" : 1    },    \"comments\" : [ {      \"note\" : 2,      \"comment\" : \"comment\",      \"id\" : 5,      \"client_id\" : 5    }, {      \"note\" : 2,      \"comment\" : \"comment\",      \"id\" : 5,      \"client_id\" : 5    } ],    \"partner\" : \"partner\",    \"phone\" : \"phone\",    \"name\" : \"name\",    \"coordinates\" : [ \"coordinates\", \"coordinates\" ],    \"description\" : \"description\",    \"id\" : 0  }}", InlineResponse2001.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse2001>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse2001>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Garage> updateGarageById(@ApiParam(value = "Unique garage identifier.", required = true) @PathVariable("id") Integer id, @ApiParam(value = "Garage data to be updated", required = true) @Valid @RequestBody Garage body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Garage>(objectMapper.readValue("{  \"id_partner\" : 6,  \"address\" : {    \"country\" : \"country\",    \"address\" : \"address\",    \"city\" : \"city\",    \"id\" : 1  },  \"comments\" : [ {    \"note\" : 2,    \"comment\" : \"comment\",    \"id\" : 5,    \"client_id\" : 5  }, {    \"note\" : 2,    \"comment\" : \"comment\",    \"id\" : 5,    \"client_id\" : 5  } ],  \"partner\" : \"partner\",  \"phone\" : \"phone\",  \"name\" : \"name\",  \"coordinates\" : [ \"coordinates\", \"coordinates\" ],  \"description\" : \"description\",  \"id\" : 0}", Garage.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Garage>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Garage>(HttpStatus.NOT_IMPLEMENTED);
    }

}
