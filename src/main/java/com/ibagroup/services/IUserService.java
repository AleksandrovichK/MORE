package com.ibagroup.services;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Max;

import com.ibagroup.dto.User;

/**
 * @author AleksandrovichK
 */
public interface IUserService {
    Long save(User newUser);

    Optional<User> findById(Long id);

    void deleteById(Long id);

    List<User> findAll();
}
