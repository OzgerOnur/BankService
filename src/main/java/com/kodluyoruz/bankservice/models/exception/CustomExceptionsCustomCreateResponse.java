package com.kodluyoruz.bankservice.models.exception;

import lombok.*;

@AllArgsConstructor
@Data
public abstract class CustomExceptionsCustomCreateResponse extends RuntimeException implements CustomCreateResponseDto {
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