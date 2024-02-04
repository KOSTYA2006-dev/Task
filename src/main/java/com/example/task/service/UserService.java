package com.example.task.service;



import com.example.task.DTO.UserDto;
import com.example.task.model.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();

    User findUserById(Long id);

}