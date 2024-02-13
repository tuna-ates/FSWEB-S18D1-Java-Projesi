package com.workintech.s18g1.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class ApiErrorResponse {
    private String message;
    private Integer status;
    private LocalDateTime localDateTime;
}
