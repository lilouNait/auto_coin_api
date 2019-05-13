package io.swagger.Exception;

import io.swagger.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ApiException.class})
    protected ResponseEntity<Error> apiException(ApiException exception) {
        Error error = new Error();
        error.setCode(exception.getCode());
        error.setMessage(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.valueOf(error.getCode()));
    }
}
