package com.ibagroup.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AleksandrovichK
 */
@RestController
public class DefaultController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String greetings() {
        return "Hello! It's me";
    }
}
