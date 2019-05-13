package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.Exception.ApiException;
import io.swagger.mapper.UserMapper;
import io.swagger.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-09T18:50:43.350+02:00")

@Controller
public class LoginApiController implements LoginApi {

    @Autowired
    UserMapper userMapper;

    private static final Logger log = LoggerFactory.getLogger(LoginApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public LoginApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> login(User body) throws ApiException {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            userMapper.login(body);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

}
