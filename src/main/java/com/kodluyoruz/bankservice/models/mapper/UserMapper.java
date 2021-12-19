package com.kodluyoruz.bankservice.models.mapper;

import com.kodluyoruz.bankservice.models.dto.UserDto;
import com.kodluyoruz.bankservice.models.entity.User;
import com.kodluyoruz.bankservice.models.request.CreateUserRequest;
import com.kodluyoruz.bankservice.models.request.UpdateUserRequest;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);


    User createRequestToUser(CreateUserRequest createUserRequest);

    UserDto toUserDto(User save);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUser(@MappingTarget User user, UpdateUserRequest updateUserRequest);
}
