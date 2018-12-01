package com.ibagroup.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibagroup.dto.User;
import com.ibagroup.dto.UserRepository;
import com.ibagroup.services.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final IUserService service;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserController(IUserService injected) {
        this.service = injected;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Optional<User> findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public Long save(@RequestBody User user) {
        return service.save(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/add")
    public @ResponseBody
    String addNewUser(@RequestBody User user) {
        userRepository.save(user);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
