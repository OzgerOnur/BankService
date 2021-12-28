package com.kodluyoruz.bankservice.models.exception.type;

import com.kodluyoruz.bankservice.models.exception.CustomExceptionsCustomCreateResponse;



public class NotFoundRequestId extends CustomExceptionsCustomCreateResponse {

    public NotFoundRequestId(){
        super("Id Not Found","Id Not Found");
    }

    public NotFoundRequestId(String messageToFront,String causeMessage){
        super(messageToFront,causeMessage);
    }

    public NotFoundRequestId(String messageToFront){
        super(messageToFront,"Id Not Found");
    }



}