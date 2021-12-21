package com.kodluyoruz.bankservice.controller;


import com.kodluyoruz.bankservice.models.dto.AccountDto;
import com.kodluyoruz.bankservice.models.dto.CustomerDto;
import com.kodluyoruz.bankservice.models.request.account.CreateAccountRequest;
import com.kodluyoruz.bankservice.models.request.account.UpdateAccountRequest;
import com.kodluyoruz.bankservice.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("{id}")
    public AccountDto getAccount(@PathVariable int id){
        return accountService.getAccount(id);
    }


    @GetMapping("{id}/customer")
    public CustomerDto getCustomer(@PathVariable int id){
        return accountService.getCustomerInformation(id);
    }

    @PostMapping
    public AccountDto createAccount(@Valid @RequestBody CreateAccountRequest createAccountRequest){
        return accountService.createAccount(createAccountRequest);
    }

    @DeleteMapping
    public void deleteAccount(@RequestParam int id){
        accountService.deleteAccount(id);
    }

    @PutMapping("{id}")
    public AccountDto updateAccount(@PathVariable int id,@Valid @RequestBody UpdateAccountRequest updateAccountRequest){
        return accountService.updateAccount(id,updateAccountRequest);
    }

    @PostMapping("{id}/withdraw-money")
    public AccountDto withdrawMoney(@PathVariable int id,@RequestParam int money){
        return accountService.withdrawMoney(id,money);
    }

    @PostMapping("{id}/deposit-money")
    public AccountDto depositMoney(@PathVariable int id,@RequestParam int money){
        return accountService.depositMoney(id,money);
    }
}
