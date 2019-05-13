package io.swagger.api;

import io.swagger.Exception.ApiException;
import io.swagger.annotations.*;
import io.swagger.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-09T18:50:43.350+02:00")

@Api(value = "login", description = "the login API")
public interface LoginApi {
    @ApiOperation(value = "Log user", nickname = "login", notes = "", tags = {"Login",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Login response")})
    @RequestMapping(value = "/login",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Void> login(@ApiParam(value = "User to connect.", required = true) @Valid @RequestBody User body) throws ApiException;
}
