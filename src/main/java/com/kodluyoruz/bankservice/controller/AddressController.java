package com.kodluyoruz.bankservice.controller;

import com.kodluyoruz.bankservice.models.dto.AddressDto;
import com.kodluyoruz.bankservice.models.request.address.UpdateCreateAddressRequest;
import com.kodluyoruz.bankservice.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("{id}")
    public AddressDto getAddress(@PathVariable int id){
        return addressService.getAddress(id);
    }

    @PostMapping
    public AddressDto createAddress(@Valid @RequestBody UpdateCreateAddressRequest updateCreateAddressRequest){
        return addressService.createAddress(updateCreateAddressRequest);
    }

    @PutMapping("{id}")
    public AddressDto updateAddress(@PathVariable int id,@Valid @RequestBody UpdateCreateAddressRequest updateCreateAddressRequest){
        return addressService.updateAddress(id,updateCreateAddressRequest);
    }

    @DeleteMapping
    public void deleteAddress(@RequestParam int id){
        addressService.deleteAddress(id);
    }
}
