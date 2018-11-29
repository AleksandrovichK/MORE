package com.ibagroup.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibagroup.dto.User;
import com.ibagroup.services.IUserService;

@RestController
@RequestMapping("/basic")
public class BasicController {
    @Autowired
    IUserService service;

    @GetMapping
    public Collection getAll(){
        return service.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/post")
    public void post(@RequestBody User user){
        service.save(user);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    public User getById(@PathVariable("id") Long id){
        return service.getById(id);
    }
}
