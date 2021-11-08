package com.example.apirest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorMessageDto {
    private Date timestamp;
    private String exception;
    private String message;
    private ArrayList<String> errors;

    public ErrorMessageDto(Date timestamp, String exception, String message) {
        this.timestamp = timestamp;
        this.exception = exception;
        this.message = message;
    }
}