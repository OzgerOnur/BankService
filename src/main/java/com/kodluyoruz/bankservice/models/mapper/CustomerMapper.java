package com.kodluyoruz.bankservice.models.mapper;


import com.kodluyoruz.bankservice.models.dto.CustomerDto;
import com.kodluyoruz.bankservice.models.entity.Customer;
import com.kodluyoruz.bankservice.models.request.customer.CreateCustomerRequest;
import com.kodluyoruz.bankservice.models.request.customer.UpdateCustomerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper CUSTOMER_MAPPER = Mappers.getMapper(CustomerMapper.class);

    CustomerDto convertToCustomerDto(Customer customer);

    List<CustomerDto> convertToCustomerDtoList(List<Customer> customers);
    Customer createCustomer(CreateCustomerRequest createCustomerRequest);

    void updateCustomer(@MappingTarget Customer customer, UpdateCustomerRequest updateCustomerRequest);
}


