package com.cosmos.multifamily.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.UnexpectedTypeException;

/**
 * Created by YoungMan on 2019-01-01.
 */

//@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(HttpServletRequest request, Exception e) {
        return new ResponseEntity<>("예외 발생 : " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(value = UserDefineException.class)
    public ResponseEntity handleUnexpectedTypeException(HttpServletRequest request, UserDefineException e) {
        return new ResponseEntity<>("예외 발생 : ", HttpStatus.BAD_REQUEST);
    }

}
