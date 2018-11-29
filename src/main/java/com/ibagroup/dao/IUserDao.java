package com.ibagroup.dao;

import java.util.Collection;

import com.ibagroup.dto.User;

/**
 * @author AleksandrovichK
 */
public interface IUserDao<T> {
    User getById(Long id);
    Collection<T> getAll();
    void save(T t);
    void update(T t);
    void delete(T t);
}
