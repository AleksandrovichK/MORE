package com.ibagroup.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibagroup.dto.RestResponse;
import com.ibagroup.dto.User;
import com.ibagroup.services.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final IUserService service;

    @Autowired
    private UserController(IUserService userService) {
        this.service = userService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Optional<User> result = service.findById(id);

        return result
                .map(user -> new ResponseEntity<>(new RestResponse(user), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(new RestResponse(), HttpStatus.NOT_FOUND));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity save(@RequestBody User user) {
        Long result = service.save(user);

        if (result != null) {
            return new ResponseEntity<>(new RestResponse(result), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new RestResponse(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/check")
    public ResponseEntity getUsers(@RequestBody User user) {
        return new ResponseEntity<>(new RestResponse(checkEmail(user.getEmail())), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/checkpassword")
    public ResponseEntity checkUsers(@RequestBody User user) {
        return new ResponseEntity<>(new RestResponse(checkUser(user.getEmail(), user.getPassword())), HttpStatus.OK);
    }

    private boolean checkEmail(String email) {
        for (User user : this.service.findAll()) {
            if (user.getEmail().equals(email))
                return true;
        }
        return false;
    }

    private boolean checkUser(String email, String password) {
        for (User user : this.service.findAll()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }
}
