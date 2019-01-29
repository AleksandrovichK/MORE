package com.ibagroup.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.ibagroup.dto.UserDto;
import com.ibagroup.services.IUserService;

/**
 * @author AleksandrovichK
 */
@Service
@Transactional
public class UserService implements UserDetailsService, IUserService {
    private final IUserDao dao;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Autowired
    public UserService(IUserDao dao) {
        this.dao = dao;
    }

    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = dao.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
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
        return optionalUser.isPresent() ? optionalUser.get() : null;
    }

    @Override
    public UserDto update(UserDto userDto) {
        User user = findById(userDto.getId());
        if(user != null) {
            BeanUtils.copyProperties(userDto, user, "password");
            dao.save(user);
        }
        return userDto;
    }

    @Override
    public User save(UserDto user) {
        User newUserOld = new User();
        newUserOld.setUsername(user.getUsername());
        newUserOld.setPassword(bcryptEncoder.encode(user.getPassword()));
       // TODO SET ALL FIELDS
        return dao.save(newUserOld);
    }
}