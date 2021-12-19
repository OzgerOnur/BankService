package com.kodluyoruz.bankservice.services;

import com.kodluyoruz.bankservice.models.dto.UserDto;
import com.kodluyoruz.bankservice.models.entity.User;
import com.kodluyoruz.bankservice.models.exception.type.NotFoundRequestId;
import com.kodluyoruz.bankservice.models.request.CreateUserRequest;
import com.kodluyoruz.bankservice.models.request.UpdateUserRequest;
import com.kodluyoruz.bankservice.models.response.PageResponse;
import com.kodluyoruz.bankservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.kodluyoruz.bankservice.models.mapper.UserMapper.USER_MAPPER;

@Service
@RequiredArgsConstructor
public class UserService {
    private UserRepository userRepository;


    public UserDto createUser(CreateUserRequest createUserRequest) {
        User user = USER_MAPPER.createRequestToUser(createUserRequest);
        return USER_MAPPER.toUserDto(userRepository.save(user));
    }


    public PageResponse<UserDto> getAllUser(PageRequest pageRequest) {
        Page<User> userPage = userRepository.findAll(pageRequest);
        Page<UserDto> userDtoPage = userPage.map(USER_MAPPER::toUserDto);
        return PageResponse.<UserDto>builder()
                .currentPage(userDtoPage.getNumber())
                .sizePage(userDtoPage.getSize())
                .tList(userDtoPage.toList())
                .build();
    }

    private User getUserEntity(Integer id){
        User user = userRepository.findById(id).orElseThrow(
                () -> new NotFoundRequestId());
        return user;
    }
    private User setUserEntity(User user){
        return userRepository.save(user);
    }

    public UserDto getUserById(Integer id) {
        User user = getUserEntity(id);
        return USER_MAPPER.toUserDto(user);
    }


    public UserDto updateUserById(Integer id, UpdateUserRequest updateUserRequest) {
        User user = getUserEntity(id);
        USER_MAPPER.updateUser(user,updateUserRequest);
        return USER_MAPPER.toUserDto(setUserEntity(user));
    }


    public void deleteUserById(Integer id) {
        getUserEntity(id);
        userRepository.deleteById(id);
    }
}
