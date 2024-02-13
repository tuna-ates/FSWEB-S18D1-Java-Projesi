package com.workintech.s18g1.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
@Slf4j
@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler
    public ResponseEntity<ApiErrorResponse> exceptionHandler(ApiException apiException){
        ApiErrorResponse apiErrorResponse=new ApiErrorResponse(apiException.getMessage(),apiException.getStatus().value(), LocalDateTime.now());
        log.error("exception accourd:",apiException.getMessage());
        return new ResponseEntity<>(apiErrorResponse,apiException.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ApiErrorResponse> exceptionHandler(Exception exception){
        ApiErrorResponse apiErrorResponse=new ApiErrorResponse(exception.getMessage(),HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
        log.error("exception accourd:",exception.getMessage());
        return new ResponseEntity<>(apiErrorResponse,HttpStatus.BAD_REQUEST);
    }
}
