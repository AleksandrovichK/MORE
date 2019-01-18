package com.ibagroup.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibagroup.dto.City;
import com.ibagroup.dto.RestResponse;
import com.ibagroup.services.ICityService;

/**
 * @author DubininaE
 */
@RestController
@RequestMapping("/cities")
public class CityController {
   /* private final ICityService service;

    private CityController(ICityService icity) {
        this.service = icity;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Optional<City> result = service.findById(id);

        return result
                .map(user -> new ResponseEntity<>(new RestResponse(user), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(new RestResponse(), HttpStatus.NOT_FOUND));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public Long save(@RequestBody City city) {
        return service.save(city);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/add")
    public String addNewUser(@RequestBody City city) {
        service.save(city);
        return "Saved";
    }*/
}
