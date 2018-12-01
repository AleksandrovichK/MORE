package com.ibagroup.services.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibagroup.dao.IUserDao;
import com.ibagroup.dto.User;
import com.ibagroup.services.IUserService;

/**
 * @author AleksandrovichK
 */
@Service
@Transactional
public class UserService implements IUserService {
    private final IUserDao dao;

    @Autowired
    public UserService(IUserDao dao) {
        this.dao = dao;
    }

    public Optional<User> findById(Long id) {
        return dao.findById(id);
    }

    public Long save(User newUser) {
        return dao.save(newUser).getId();
    }

    public void deleteById(Long id) {
        dao.deleteById(id);
    }
}