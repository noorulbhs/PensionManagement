package com.fse0.microservice.loginservice.exceptions;

import org.apache.http.impl.io.EmptyInputStream;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    public ResponseEntity<String> handleEmptyInput(){
        return new ResponseEntity<String>("Input Field is Empty", HttpStatus.BAD_REQUEST);
    }
}
