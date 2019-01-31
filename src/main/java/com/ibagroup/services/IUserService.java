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

    User create(User user);

    void update(User user);

}
