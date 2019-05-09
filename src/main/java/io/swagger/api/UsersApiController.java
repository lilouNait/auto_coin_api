package io.swagger.api;

import io.swagger.model.Error;
import io.swagger.model.InlineResponse2002;
import io.swagger.model.InlineResponse2003;
import io.swagger.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-09T18:10:30.316+02:00")

@Controller
public class UsersApiController implements UsersApi {

    private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<User> createUser(@ApiParam(value = "User to be created." ,required=true )  @Valid @RequestBody User body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<User>(objectMapper.readValue("{  \"password\" : \"password\",  \"phone\" : \"phone\",  \"name\" : \"name\",  \"id\" : 0,  \"first_name\" : \"first_name\",  \"email\" : \"email\",  \"username\" : \"username\",  \"status\" : \"client\"}", User.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteUserById(@ApiParam(value = "Unique user identifier.",required=true) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse2002> getUser(@ApiParam(value = "Search by name.") @Valid @RequestParam(value = "Search by name", required = false) String searchByName,@ApiParam(value = "Search by username.") @Valid @RequestParam(value = "username", required = false) String username,@ApiParam(value = "Search by email.") @Valid @RequestParam(value = "email", required = false) String email,@ApiParam(value = "Search by status.") @Valid @RequestParam(value = "status", required = false) String status) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse2002>(objectMapper.readValue("{  \"data\" : [ {    \"password\" : \"password\",    \"phone\" : \"phone\",    \"name\" : \"name\",    \"id\" : 0,    \"first_name\" : \"first_name\",    \"email\" : \"email\",    \"username\" : \"username\",    \"status\" : \"client\"  }, {    \"password\" : \"password\",    \"phone\" : \"phone\",    \"name\" : \"name\",    \"id\" : 0,    \"first_name\" : \"first_name\",    \"email\" : \"email\",    \"username\" : \"username\",    \"status\" : \"client\"  } ]}", InlineResponse2002.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse2002>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse2002>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<InlineResponse2003> getUserById(@ApiParam(value = "Unique user identifier.",required=true) @PathVariable("id") Integer id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse2003>(objectMapper.readValue("{  \"data\" : {    \"password\" : \"password\",    \"phone\" : \"phone\",    \"name\" : \"name\",    \"id\" : 0,    \"first_name\" : \"first_name\",    \"email\" : \"email\",    \"username\" : \"username\",    \"status\" : \"client\"  }}", InlineResponse2003.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse2003>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse2003>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<User> updateUserById(@ApiParam(value = "Unique user identifier.",required=true) @PathVariable("id") Integer id,@ApiParam(value = "User data to be updated" ,required=true )  @Valid @RequestBody User body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<User>(objectMapper.readValue("{  \"password\" : \"password\",  \"phone\" : \"phone\",  \"name\" : \"name\",  \"id\" : 0,  \"first_name\" : \"first_name\",  \"email\" : \"email\",  \"username\" : \"username\",  \"status\" : \"client\"}", User.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
    }

}
