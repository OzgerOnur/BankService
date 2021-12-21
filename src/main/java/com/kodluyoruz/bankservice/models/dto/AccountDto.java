package com.kodluyoruz.bankservice.models.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {


    private Integer id;

    private Integer customerId;

    private String customerName;

    private String currency;

    private String iban;

    private int balance;
}
