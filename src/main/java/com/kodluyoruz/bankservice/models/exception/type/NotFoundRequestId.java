package com.kodluyoruz.bankservice.models.exception.type;

import com.kodluyoruz.bankservice.models.exception.ExceptionsResponse;



public class NotFoundRequestId extends ExceptionsResponse {

    public NotFoundRequestId(){
        super("Id Not Found","Id Not Found");
    }

    public NotFoundRequestId(String messageToFront,String causeMessage){
        super(messageToFront,causeMessage);
    }



}