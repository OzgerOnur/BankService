package com.kodluyoruz.bankservice.models.exception.type;

import com.kodluyoruz.bankservice.models.exception.CustomExceptionResponseDto;
import com.kodluyoruz.bankservice.models.exception.CustomExceptionsCustomCreateResponse;
import com.kodluyoruz.bankservice.models.exception.CustomCreateResponseDto;


public class CantDeleteThisId extends CustomExceptionsCustomCreateResponse  {

    public CantDeleteThisId() {
        super("The id cant be deleted", "the id have not existed or being secured by others");
    }

    public CantDeleteThisId(String messageToFront, String cause) {
        super(messageToFront, cause);
    }

    public CantDeleteThisId(String cause) {
        super("The id cant be deleted", cause);
    }




}
