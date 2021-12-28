package com.kodluyoruz.bankservice.models.exception.type;

import com.kodluyoruz.bankservice.models.exception.CustomExceptionsResponse;


public class CantDeleteThisId extends CustomExceptionsResponse {

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
