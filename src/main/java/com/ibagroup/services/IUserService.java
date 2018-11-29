package com.ibagroup.services;

import java.util.Collection;

import com.ibagroup.dto.User;

/**
 * @author AleksandrovichK
 */
public interface IUserService {
    void save(User newUser);

    User getById(Long id);

    Collection getAll();
}
