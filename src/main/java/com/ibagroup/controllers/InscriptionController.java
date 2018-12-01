package com.ibagroup.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibagroup.dao.InscriptionDAO;
import com.ibagroup.dto.Inscription;

/**
 * @author DubininaE
 */
@RestController
@RequestMapping("/ins")
public class InscriptionController {
    @Autowired
    private InscriptionDAO inscriptionDAO;

    @RequestMapping(method = RequestMethod.PUT, value = "/add")
    public @ResponseBody
    String addNewUser(@RequestBody Inscription inscription) {
        inscriptionDAO.save(inscription);
        return "Saved";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{name}")
    public Optional<Inscription> findById(@PathVariable("name") String name) {
        return inscriptionDAO.findById(name);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/delete")
    public void delete(@RequestParam String name) {
        inscriptionDAO.deleteById(name);
    }

}
