package com.ibagroup.dao.impl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.ibagroup.dao.IUserDao;
import com.ibagroup.dto.User;

/**
 * @author AleksandrovichK
 * @author DubininaE
 */
@Component
public class UserDao<T> implements IUserDao {
    @Override
    public Collection getAll() {
        return null;
    }

    @Override
    public void save(Object o) {
        // SQL -> INSERT o to TABLE ...
    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public User getById(Long id) {
        return new User(id, "Petrov", "petrov@gmail.com", "uaregay", new Date(), new BigDecimal(2.0), new Short("2"), false);
    }
}
