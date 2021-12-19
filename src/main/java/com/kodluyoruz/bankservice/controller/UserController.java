package com.kodluyoruz.bankservice.controller;

import com.kodluyoruz.bankservice.models.dto.UserDto;
import com.kodluyoruz.bankservice.models.request.CreateUserRequest;
import com.kodluyoruz.bankservice.models.request.UpdateUserRequest;
import com.kodluyoruz.bankservice.models.response.PageResponse;
import com.kodluyoruz.bankservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    //crud
    @PostMapping()
    public UserDto createUser(@RequestBody CreateUserRequest createUserRequest){
        return userService.createUser(createUserRequest);
    }

    @GetMapping()
    public PageResponse<UserDto> getAllUser(@RequestParam int currentPage, @RequestParam int sizePage){
        currentPage = (currentPage <= 0) ? 0 : currentPage - 1;
        return userService.getAllUser(PageRequest.of(currentPage,sizePage));
    }

    @GetMapping("{id}")
    public UserDto getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @PatchMapping("{id}")
    public UserDto updateUserById(@PathVariable Integer id,@RequestBody UpdateUserRequest updateUserRequest){
        return userService.updateUserById(id,updateUserRequest);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable Integer id){
         userService.deleteUserById(id);
    }


}
