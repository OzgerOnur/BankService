package com.kodluyoruz.bankservice.models.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomExceptionsCustomCreateResponse.class)
    public ResponseEntity<CustomExceptionResponseDto> writtenException(CustomExceptionsCustomCreateResponse customExceptionsResponse) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(customExceptionsResponse.getExceptionDto());
    }






}