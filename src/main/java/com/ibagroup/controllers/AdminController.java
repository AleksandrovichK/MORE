package com.ibagroup.controllers;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AleksandrovichK
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET, produces = "application/json")
    public String message(@PathVariable String name) {
        return "Hi, admin!";
    }

}
