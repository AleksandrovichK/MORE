package com.ibagroup.services;

import java.util.List;

import com.ibagroup.dto.User;

/**
 * @author AleksandrovichK
 */

public interface IUserService {
    List<User> findAll();

    User findOne(String username);

    @Deprecated
    User findById(Long id);

    void deleteById(Long id);

    @Deprecated
    User save(User user);

    @Deprecated
    User update(User userDto);
}
