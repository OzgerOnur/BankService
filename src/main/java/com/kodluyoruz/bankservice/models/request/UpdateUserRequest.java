package com.kodluyoruz.bankservice.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdateUserRequest {

    private Integer id;
    private String name;
    private String mail;
    private List<Integer> accountId;

}
