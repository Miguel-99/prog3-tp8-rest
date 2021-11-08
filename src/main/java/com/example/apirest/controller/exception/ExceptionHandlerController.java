package com.example.apirest.controller.exception;

import com.example.apirest.dto.ErrorMessageDto;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessageDto> handleNotFoundException(NotFoundException exception){

        return ResponseEntity.status(NOT_FOUND).body(ErrorMessageDto.builder()
                .timestamp(new Date())
                .exception("NotFoundException")
                .message(exception.getMessage())
                .build());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessageDto usernameNotFoundException(Exception ex) {
        return new ErrorMessageDto(new Date(), "Exception", ex.getMessage());
    }
}
