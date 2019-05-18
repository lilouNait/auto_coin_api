package io.swagger.api;

import io.swagger.Exception.ApiException;
import io.swagger.annotations.*;
import io.swagger.model.Error;
import io.swagger.model.InlineResponse2002;
import io.swagger.model.InlineResponse2003;
import io.swagger.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-09T18:50:43.350+02:00")

@Api(value = "users", description = "the users API")
public interface UsersApi {

    @ApiOperation(value = "Create a new User.", nickname = "createUser", notes = "", response = User.class, tags = {"User",})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Create garage response", response = User.class),
            @ApiResponse(code = 200, message = "Unexpected error", response = Error.class)})
    @RequestMapping(value = "/users",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<User> createUser(@ApiParam(value = "User to be created.", required = true) @Valid @RequestBody User body) throws Exception;


    @ApiOperation(value = "Delete a user.", nickname = "deleteUserById", notes = "", tags = {"User",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Delete user response"),
            @ApiResponse(code = 200, message = "Unexpected error", response = Error.class)})
    @RequestMapping(value = "/users/{id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteUserById(@ApiParam(value = "Unique user identifier.", required = true) @PathVariable("id") Integer id) throws ApiException;


    @ApiOperation(value = "Get all users.", nickname = "getUser", notes = "", response = InlineResponse2002.class, tags = {"User",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User response", response = InlineResponse2002.class),
            @ApiResponse(code = 200, message = "Unexpected error", response = Error.class)})
    @RequestMapping(value = "/users",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<InlineResponse2002> getUser(@ApiParam(value = "Search by name.") @Valid @RequestParam(value = "name", required = false) String name, @ApiParam(value = "Search by username.") @Valid @RequestParam(value = "username", required = false) String username, @ApiParam(value = "Search by email.") @Valid @RequestParam(value = "email", required = false) String email, @ApiParam(value = "Search by status.") @Valid @RequestParam(value = "status", required = false) String status);


    @ApiOperation(value = "Get a User", nickname = "getUserById", notes = "", response = InlineResponse2003.class, tags = {"User",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User response", response = InlineResponse2003.class),
            @ApiResponse(code = 200, message = "Unexpected error", response = Error.class)})
    @RequestMapping(value = "/users/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<InlineResponse2003> getUserById(@ApiParam(value = "Unique user identifier.", required = true) @PathVariable("id") Integer id) throws ApiException;


    @ApiOperation(value = "Update a user.", nickname = "updateUserById", notes = "", response = User.class, tags = {"User",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Update user response", response = User.class),
            @ApiResponse(code = 200, message = "Unexpected error", response = Error.class)})
    @RequestMapping(value = "/users/{id}",
            produces = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<User> updateUserById(@ApiParam(value = "Unique user identifier.", required = true) @PathVariable("id") Integer id, @ApiParam(value = "User data to be updated", required = true) @Valid @RequestBody User body) throws Exception;

}
