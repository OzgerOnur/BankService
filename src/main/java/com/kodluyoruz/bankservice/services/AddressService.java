package com.kodluyoruz.bankservice.services;


import com.kodluyoruz.bankservice.models.dto.AddressDto;
import com.kodluyoruz.bankservice.models.entity.Address;
import com.kodluyoruz.bankservice.models.exception.type.CantDeleteThisId;
import com.kodluyoruz.bankservice.models.exception.type.NotFoundRequestId;
import com.kodluyoruz.bankservice.models.request.address.UpdateCreateAddressRequest;
import com.kodluyoruz.bankservice.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import static com.kodluyoruz.bankservice.models.mapper.AddressMapper.ADDRESS_MAPPER;


@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    public AddressDto createAddress(UpdateCreateAddressRequest updateCreateAddressRequest){
        Address address = ADDRESS_MAPPER.createAddress(updateCreateAddressRequest);
        return ADDRESS_MAPPER.convertToAddressDto(addressRepository.save(address));
    }

    public AddressDto getAddress(int id){
        return ADDRESS_MAPPER.convertToAddressDto(getAddressById(id));
    }

    public AddressDto updateAddress(int id,UpdateCreateAddressRequest updateCreateAddressRequest){
        Address address = getAddressById(id);
        ADDRESS_MAPPER.updateAddress(address,updateCreateAddressRequest);
        return ADDRESS_MAPPER.convertToAddressDto(addressRepository.save(address));
    }

    private Address getAddressById(int id) {
        return addressRepository.findById(id).orElseThrow(()->new NotFoundRequestId("Address cannot be found"));
    }

    public void deleteAddress(int id){
        try {
            addressRepository.deleteById(id);
        }
        catch (RuntimeException runtimeException){
            throw new CantDeleteThisId();
        }

    }

}
