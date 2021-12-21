package com.kodluyoruz.bankservice.controller;

import com.kodluyoruz.bankservice.models.dto.CustomerDto;
import com.kodluyoruz.bankservice.models.request.customer.CreateCustomerRequest;
import com.kodluyoruz.bankservice.models.request.customer.UpdateCustomerRequest;
import com.kodluyoruz.bankservice.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("{id}")
    public CustomerDto getCustomer(@PathVariable int id){
        return customerService.getCustomer(id);
    }


    @PostMapping
    public CustomerDto createCustomer(@Valid  @RequestBody CreateCustomerRequest createCustomerRequest){
        return customerService.createCustomer(createCustomerRequest);
    }

    @PutMapping("{id}")
    public CustomerDto updateCustomer(@PathVariable int id,@Valid @RequestBody UpdateCustomerRequest updateCustomerRequest){
        return customerService.updateCustomer(id,updateCustomerRequest);
    }

    @DeleteMapping
    public void deleteCustomer(@RequestParam int id){
        customerService.deleteCustomer(id);
    }
}
