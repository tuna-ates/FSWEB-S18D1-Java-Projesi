package com.workintech.s18g1.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Data
public class ApiException extends RuntimeException {
    private HttpStatus status;


    public ApiException(String message, HttpStatus status) {
        super(message);
        this.status = status;

    }
}
