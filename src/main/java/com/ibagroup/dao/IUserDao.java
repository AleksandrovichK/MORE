package com.ibagroup.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibagroup.dto.User;

/**
 * Implementation for this interface will be generated automatically. And this implementation
 * should be injected via @Autowired or @Inject annotation.
 *
 * @author AleksandrovichK
 */
@Repository
public interface IUserDao extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
