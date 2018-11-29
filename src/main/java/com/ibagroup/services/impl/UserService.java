package com.ibagroup.services.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.ibagroup.dao.IUserDao;
import com.ibagroup.dto.User;
import com.ibagroup.services.IUserService;

/**
 * @author AleksandrovichK
 */
@SessionScope
@Component(value = "userService")
public class UserService implements IUserService {

    @Autowired
    private IUserDao<User> dao;

    public void save(User newUser) {
        dao.save(newUser);
    }

    public User getById(Long id){
        return dao.getById(id);
    }

    public Collection getAll() {
        return dao.getAll();
    }

}