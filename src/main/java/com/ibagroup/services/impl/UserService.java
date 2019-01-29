package com.ibagroup.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.jws.soap.SOAPBinding;
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

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = dao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
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
    public User findOne(String username) {
        return dao.findByUsername(username);
    }

    @Override
    public User findById(Long id) {
        Optional<User> optionalUser = dao.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    public User update(User userData) {
        User user = findById(userData.getId());
        if (user != null) {
            BeanUtils.copyProperties(userData, user, "password");
            dao.save(user);
        }
        return userData;
    }

    @Override
    public User save(User user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(encoder.encode(user.getPassword()));
        // TODO SET ALL FIELDS
        return dao.save(newUser);
    }

    @Override
    public boolean checkEmail(String email) {
        for (User user : dao.findAll()) {
            if (user.getEmail().equals(email))
                return true;
        }
        return false;
    }

    @Override
    public boolean checkUser(String email, String password) {
        List<User>users = dao.findAll();
        for (User user : dao.findAll()) {
            if(user.getEmail()!= null)
            if (user.getEmail().equals(email) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }
}