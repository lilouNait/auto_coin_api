package io.swagger.api;

import io.swagger.Exception.ApiException;
import io.swagger.annotations.*;
import io.swagger.model.Error;
import io.swagger.model.Garage;
import io.swagger.model.InlineResponse200;
import io.swagger.model.InlineResponse2001;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-09T18:50:43.350+02:00")

@Api(value = "garages", description = "the garages API")
public interface GaragesApi {

    @ApiOperation(value = "Create a new Garage.", nickname = "createGarage", notes = "", response = Garage.class, tags = {"Garage",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Create garage response", response = Garage.class)})
    @RequestMapping(value = "/garages",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Garage> createGarage(@ApiParam(value = "Garage to be created.", required = true) @Valid @RequestBody Garage body) throws Exception;


    @ApiOperation(value = "Delete a garage.", nickname = "deleteGarageById", notes = "", tags = {"Garage",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Delete garage response"),
            @ApiResponse(code = 200, message = "Unexpected error", response = Error.class)})
    @RequestMapping(value = "/garages/{id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteGarageById(@ApiParam(value = "Unique garage identifier.", required = true) @PathVariable("id") Integer id) throws ApiException;


    @ApiOperation(value = "Get all garages.", nickname = "getGarage", notes = "", response = InlineResponse200.class, tags = {"Garage",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Garage response", response = InlineResponse200.class),
            @ApiResponse(code = 200, message = "Unexpected error", response = Error.class)})
    @RequestMapping(value = "/garages",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<InlineResponse200> getGarage(@ApiParam(value = "Search by name.") @Valid @RequestParam(value = "name", required = false) String searchByName, @ApiParam(value = "Search by partner.") @Valid @RequestParam(value = "partner", required = false) Integer partner, @ApiParam(value = "Search by address.") @Valid @RequestParam(value = "address", required = false) String address);


    @ApiOperation(value = "Get a Garage", nickname = "getGarageById", notes = "", response = InlineResponse2001.class, tags = {"Garage",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Garage response", response = InlineResponse2001.class),
            @ApiResponse(code = 200, message = "Unexpected error", response = Error.class)})
    @RequestMapping(value = "/garages/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<InlineResponse2001> getGarageById(@ApiParam(value = "Unique garage identifier.", required = true) @PathVariable("id") Integer id) throws ApiException;


    @ApiOperation(value = "Update a garage.", nickname = "updateGarageById", notes = "", response = Garage.class, tags = {"Garage",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Update garage response", response = Garage.class),
            @ApiResponse(code = 200, message = "Unexpected error", response = Error.class)})
    @RequestMapping(value = "/garages/{id}",
            produces = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<Garage> updateGarageById(@ApiParam(value = "Unique garage identifier.", required = true) @PathVariable("id") Integer id, @ApiParam(value = "Garage data to be updated", required = true) @Valid @RequestBody Garage body) throws Exception;

}
