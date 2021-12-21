package com.kodluyoruz.bankservice.models.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDto {
    private Integer id;

    private String city;

    private String district;

    private String neighbourhood;

    private String buildingNumber;

    private String flatNumber;


}
