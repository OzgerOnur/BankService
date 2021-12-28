package com.kodluyoruz.bankservice.services;


import com.kodluyoruz.bankservice.models.dto.AccountDto;
import com.kodluyoruz.bankservice.models.dto.CustomerDto;
import com.kodluyoruz.bankservice.models.entity.Account;
import com.kodluyoruz.bankservice.models.exception.type.CantDeleteThisId;
import com.kodluyoruz.bankservice.models.exception.type.NotFoundRequestId;
import com.kodluyoruz.bankservice.models.request.account.CreateAccountRequest;
import com.kodluyoruz.bankservice.models.request.account.UpdateAccountRequest;
import com.kodluyoruz.bankservice.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import static com.kodluyoruz.bankservice.models.mapper.AccountMapper.ACCOUNT_MAPPER;
import static com.kodluyoruz.bankservice.models.mapper.CustomerMapper.CUSTOMER_MAPPER;


@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountDto createAccount(CreateAccountRequest createAccountRequest){
        Account account = ACCOUNT_MAPPER.createAccount(createAccountRequest);
        return ACCOUNT_MAPPER.convertToAccountDto(accountRepository.save(account));
    }

    public AccountDto updateAccount(int id, UpdateAccountRequest updateAccountRequest){
        Account account = getAccountBtId(id);
        ACCOUNT_MAPPER.updateAccount(account,updateAccountRequest);
        return ACCOUNT_MAPPER.convertToAccountDto(accountRepository.save(account));
    }

    private Account getAccountBtId(int id) {
        return accountRepository.findById(id).orElseThrow(()->new NotFoundRequestId("Account cannot be found"));
    }

    public AccountDto withdrawMoney(int id,int money){
        Account account = getAccountBtId(id);
        if (account.getBalance()<money){
            // TODO: 12/21/21 Buraya hata basilmali
        }
        account.setBalance(account.getBalance()-money);
        return ACCOUNT_MAPPER.convertToAccountDto(accountRepository.save(account));
    }
    public CustomerDto getCustomerInformation(int id){
        Account account = getAccountBtId(id);
        return CUSTOMER_MAPPER.convertToCustomerDto(account.getCustomer());
    }
    public AccountDto depositMoney(int id,int money){
        Account account = getAccountBtId(id);
        account.setBalance(account.getBalance()+money);
        return ACCOUNT_MAPPER.convertToAccountDto(accountRepository.save(account));
    }

    public void deleteAccount(int id){
        try {
            accountRepository.deleteById(id);
        }
        catch (RuntimeException runtimeException){
            throw new CantDeleteThisId();
        }
    }

    public AccountDto getAccount(int id){
        return ACCOUNT_MAPPER.convertToAccountDto(getAccountBtId(id));
    }
}
