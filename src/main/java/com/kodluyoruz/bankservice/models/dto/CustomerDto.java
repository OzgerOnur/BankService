package com.kodluyoruz.bankservice.models.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Integer id;

    private String name;

    private Date birthday;

    private AddressDto address;

    private String phone;

    private String email;
}
