package com.ibagroup.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibagroup.dto.User;

/**
 * Implementation for this interface will be generated automatically. And this implementation
 * should be injected via @Autowired or @Inject annotation.
 *
 * @author AleksandrovichK
 */
@Repository
public interface IUserDao extends CrudRepository<User, Long> {
}
