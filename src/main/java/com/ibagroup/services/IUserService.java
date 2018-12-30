package com.ibagroup.services;

import java.util.Optional;

import com.ibagroup.dto.User;

/**
 * @author AleksandrovichK
 */
public interface IUserService {
    Long save(User newUser);

    Long change(User newUser);

    Optional<User> findById(Long id);

    void deleteById(Long id);
}
