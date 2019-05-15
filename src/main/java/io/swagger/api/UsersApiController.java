package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.Exception.ApiException;
import io.swagger.annotations.ApiParam;
import io.swagger.mapper.UserMapper;
import io.swagger.model.InlineResponse2002;
import io.swagger.model.InlineResponse2003;
import io.swagger.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-09T18:50:43.350+02:00")

@Controller
public class UsersApiController implements UsersApi {

    @Autowired
    private UserMapper userMapper;

    private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);


    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request) throws Exception {
        this.request = request;
    }

    public ResponseEntity<User> createUser(@ApiParam(value = "User to be created.", required = true) @Valid @RequestBody User body) throws Exception {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<User>(userMapper.createUser(body), HttpStatus.CREATED);
        } else return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Void> deleteUserById(@ApiParam(value = "Unique user identifier.", required = true) @PathVariable("id") Integer id) throws ApiException {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            userMapper.deleteUserById(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<InlineResponse2002> getUser(@ApiParam(value = "Search by name.") @Valid @RequestParam(value = "name", required = false) String name, @ApiParam(value = "Search by username.") @Valid @RequestParam(value = "username", required = false) String username, @ApiParam(value = "Search by email.") @Valid @RequestParam(value = "email", required = false) String email, @ApiParam(value = "Search by status.") @Valid @RequestParam(value = "status", required = false) String status) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<InlineResponse2002>(userMapper.getUser(name, username, email, status), HttpStatus.OK);
        } else return new ResponseEntity<InlineResponse2002>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<InlineResponse2003> getUserById(@ApiParam(value = "Unique user identifier.", required = true) @PathVariable("id") Integer id) throws ApiException {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<InlineResponse2003>(userMapper.getUserById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<InlineResponse2003>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<User> updateUserById(@ApiParam(value = "Unique user identifier.", required = true) @PathVariable("id") Integer id, @ApiParam(value = "User data to be updated", required = true) @Valid @RequestBody User body) throws ApiException {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<User>(userMapper.updateUserById(id, body), HttpStatus.OK);
        } else return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
    }

}
