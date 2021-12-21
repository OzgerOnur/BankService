package com.kodluyoruz.bankservice.models.mapper;


import com.kodluyoruz.bankservice.models.dto.AccountDto;
import com.kodluyoruz.bankservice.models.entity.Account;
import com.kodluyoruz.bankservice.models.request.account.CreateAccountRequest;
import com.kodluyoruz.bankservice.models.request.account.UpdateAccountRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountMapper ACCOUNT_MAPPER = Mappers.getMapper(AccountMapper.class);


    @Mapping(source = "customer.name",target = "customerName")
    AccountDto convertToAccountDto(Account account);

    void updateAccount(@MappingTarget Account account, UpdateAccountRequest updateAccountRequest);

    Account createAccount(CreateAccountRequest createAccountRequest);
}
