package com.ibagroup.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.ibagroup.dao.InscriptionDao;
import com.ibagroup.dto.Inscription;
import com.ibagroup.dto.RestResponse;

/**
 * @author DubininaE
 */
@RestController
@RequestMapping("/ins")
public class IInscriptionController {
    private final InscriptionDao service;

    @Autowired
    private IInscriptionController(InscriptionDao injected) {
        this.service = injected;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/add")
    public String addNewUser(@RequestBody Inscription inscription) {
        service.save(inscription);
        return "Saved";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Optional<Inscription> findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/delete")
    public void delete(@RequestParam Long id) {
        service.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/properties")
    public RestResponse getAllUsers() {
        return new RestResponse(service.findAll());
    }

}
