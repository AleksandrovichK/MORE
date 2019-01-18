package com.ibagroup.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    private final ICityService service;

    @Autowired
    private CityController(ICityService city) {
        this.service = city;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Optional<City> result = service.findById(id);

        return result
                .map(City -> new ResponseEntity<>(new RestResponse(City), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(new RestResponse(), HttpStatus.NOT_FOUND));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity save(@RequestBody City City) {
        Long result = service.save(City);

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

    @RequestMapping(method = RequestMethod.GET, value = "/id")
    public ResponseEntity getIdByCity(@RequestParam String city) {
        List<City> cities = this.service.findAll();
        for (City s : cities) {
            if (s.getCityFrom().equals(city)) {
                return new ResponseEntity<>(s.getId(), HttpStatus.OK);

            }
        }
        return new ResponseEntity<>(new RestResponse(), HttpStatus.BAD_REQUEST);
    }
}
