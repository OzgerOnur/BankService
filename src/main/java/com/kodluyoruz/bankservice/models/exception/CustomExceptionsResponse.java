package com.kodluyoruz.bankservice.models.exception;

import lombok.*;

@AllArgsConstructor
@Data
public abstract class CustomExceptionsResponse extends RuntimeException implements CustomCreateResponse {
    private String messageToFront;
    private String causeToFront;

    @Override
    public CustomExceptionResponseDto getExceptionDto() {
        return CustomExceptionResponseDto.builder()
                .cause(this.causeToFront)
                .message(this.messageToFront)
                .build();
    }
}