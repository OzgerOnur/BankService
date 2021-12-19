package com.kodluyoruz.bankservice.models.exception;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class ExceptionsResponse extends RuntimeException{
    private String messageToFront;
    private String causeMessage;



}