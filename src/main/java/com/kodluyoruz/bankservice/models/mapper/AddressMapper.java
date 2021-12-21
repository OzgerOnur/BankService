package com.kodluyoruz.bankservice.models.mapper;

import com.kodluyoruz.bankservice.models.dto.AddressDto;
import com.kodluyoruz.bankservice.models.entity.Address;
import com.kodluyoruz.bankservice.models.request.address.UpdateCreateAddressRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressMapper ADDRESS_MAPPER = Mappers.getMapper(AddressMapper.class);

    AddressDto convertToAddressDto(Address address);

    void updateAddress(@MappingTarget Address address, UpdateCreateAddressRequest updateCreateAddressRequest);

    Address createAddress(UpdateCreateAddressRequest updateCreateAddressRequest);
}
