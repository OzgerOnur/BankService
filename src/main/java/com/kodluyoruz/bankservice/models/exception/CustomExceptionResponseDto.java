package com.kodluyoruz.bankservice.models.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class CustomExceptionResponseDto {
    private String message;
    private String cause;

}
