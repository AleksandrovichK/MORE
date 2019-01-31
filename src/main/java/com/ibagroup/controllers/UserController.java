package com.ibagroup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibagroup.dto.RestResponse;
import com.ibagroup.dto.User;
import com.ibagroup.services.IUserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    private final IUserService service;

    @Autowired
    private UserController(IUserService userService) {
        this.service = userService;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity updateUser(@RequestBody User user) {
        service.update(user);
        return new ResponseEntity<>(new RestResponse(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/credentials")
    public ResponseEntity findByUsername(@RequestParam("username") String username) {
        User result = service.findOne(username);
        if (result != null) {
            result.setPassword(null);
        }

        if (result != null) {
            return new ResponseEntity<>(new RestResponse(result), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new RestResponse(), HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
}
