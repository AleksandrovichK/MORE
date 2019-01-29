package com.ibagroup.services;

import java.util.List;

import com.ibagroup.dto.User;
import com.ibagroup.dto.UserDto;

/**
 * @author AleksandrovichK
 */

public interface IUserService {
    List<User> findAll();

    User findOne(String username);

    User findById(Long id);

    void deleteById(Long id);

    User save(UserDto user);

    UserDto update(UserDto userDto);
}
