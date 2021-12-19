package com.kodluyoruz.bankservice.models.exception;

import com.kodluyoruz.bankservice.models.exception.type.NotFoundRequestId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExceptionsResponse.class)
    public ResponseEntity<ExceptionsResponse> writenException(ExceptionsResponse exceptionsResponse) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(exceptionsResponse);
    }




}