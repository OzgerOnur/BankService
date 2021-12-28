package com.kodluyoruz.bankservice.services;


import com.kodluyoruz.bankservice.models.dto.CustomerDto;
import com.kodluyoruz.bankservice.models.entity.Customer;
import com.kodluyoruz.bankservice.models.exception.type.CantDeleteThisId;
import com.kodluyoruz.bankservice.models.exception.type.NotFoundRequestId;
import com.kodluyoruz.bankservice.models.request.customer.CreateCustomerRequest;
import com.kodluyoruz.bankservice.models.request.customer.UpdateCustomerRequest;
import com.kodluyoruz.bankservice.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kodluyoruz.bankservice.models.mapper.CustomerMapper.CUSTOMER_MAPPER;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerDto createCustomer(CreateCustomerRequest createCustomerRequest){
        Customer customer = CUSTOMER_MAPPER.createCustomer(createCustomerRequest);
        return CUSTOMER_MAPPER.convertToCustomerDto(customerRepository.save(customer));
    }

    public CustomerDto updateCustomer(int id, UpdateCustomerRequest updateCustomerRequest){
        Customer customer = getCustomerById(id);
        CUSTOMER_MAPPER.updateCustomer(customer,updateCustomerRequest);
        return CUSTOMER_MAPPER.convertToCustomerDto(customerRepository.save(customer));
    }

    private Customer getCustomerById(int id){
        return customerRepository.findById(id).orElseThrow(()->new NotFoundRequestId("Customer cannot be found"));
    }

    public CustomerDto getCustomer(int id){
        return CUSTOMER_MAPPER.convertToCustomerDto(getCustomerById(id));
    }

    public void deleteCustomer(int id){
        try {
            customerRepository.deleteById(id);
        }
        catch (RuntimeException runtimeException){
            throw new CantDeleteThisId();
        }
    }
}
