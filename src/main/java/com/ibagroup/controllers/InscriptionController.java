package com.ibagroup.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibagroup.dao.InscriptionDAO;
import com.ibagroup.dto.Inscription;
import com.ibagroup.dto.RestResponse;
import com.ibagroup.dto.User;

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

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Optional<Inscription> findById(@PathVariable("id") Long id) {
        return inscriptionDAO.findById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/delete")
    public void delete(@RequestParam Long id) {
        inscriptionDAO.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/properties")
    public RestResponse getProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("tab1", "Покушать");
        properties.put("tab2", "Посмотреть");
        properties.put("tab3", "Поиграться");

        properties.put("tab1_description", "Итальяно ресторано, француано микошиано");
        properties.put("tab2_description", "Ну музеев там много, прочей херни");
        properties.put("tab3_description", "Игры игрушки");

        return new RestResponse(properties);
    }

    @GetMapping(path = "/all")
    public RestResponse getAllUsers() {
        Map<Long, Inscription> properties = new HashMap<>();
        properties = Collectors.toMap(Inscription::getId, getCollectionFromIteralbe(inscriptionDAO.findAll()));
    }

    public static <T> Collection<T>
    getCollectionFromIteralbe(Iterable<T> itr) {
        // Create an empty Collection to hold the result
        Collection<T> cltn = new ArrayList<T>();

        // Iterate through the iterable to
        // add each element into the collection
        for (T t : itr)
            cltn.add(t);

        // Return the converted collection
        return cltn;
    }

}
