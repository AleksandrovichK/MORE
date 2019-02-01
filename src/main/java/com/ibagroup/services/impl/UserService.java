package com.ibagroup.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ibagroup.dao.IUserDao;
import com.ibagroup.dto.User;
import com.ibagroup.services.IUserService;

/**
 * @author AleksandrovichK
 */
@Service
@Transactional
public class UserService implements UserDetailsService, IUserService {
    private final IUserDao dao;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserService(IUserDao dao, BCryptPasswordEncoder encoder) {
        this.dao = dao;
        this.encoder = encoder;
    }

    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = dao.findByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid login or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        dao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public User findOne(String login) {
        return dao.findByLogin(login);
    }

    @Override
    public User findById(Long id) {
        Optional<User> optionalUser = dao.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    public void update(User userData) {
        User user = findById(userData.getId());
        if (user != null) {
            BeanUtils.copyProperties(userData, user, "login");
            user.setPassword(encoder.encode(userData.getPassword()));
            dao.save(user);
        }
    }

    @Override
    public User create(User user) {
        User check = findOne(user.getLogin());
        if (check == null) {
            user.setRole("ROLE_USER");
            user.setRegistrationDate(new Date());
            user.setTravelsCount(0);
            user.setPassword(encoder.encode(user.getPassword()));
            return dao.save(user);
        } else
            return null;
    }
}