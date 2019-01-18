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

import com.ibagroup.dto.RestResponse;
import com.ibagroup.dto.Trip;
import com.ibagroup.services.ITripService;

@RestController
@RequestMapping("/trips")
public class TripController {
    private final ITripService service;

    @Autowired
    private TripController(ITripService trip) {
        this.service = trip;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Optional<Trip> result = service.findById(id);

        return result
                .map(user -> new ResponseEntity<>(new RestResponse(user), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(new RestResponse(), HttpStatus.NOT_FOUND));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public Long save(@RequestBody Trip trip) {
        return service.save(trip);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/add")
    public String addNewUser(@RequestBody Trip trip) {
        service.save(trip);
        return "Saved";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/tr")
    public RestResponse findById(@RequestParam Long p1, @RequestParam Long p2) {
            List<Trip> trips = this.service.findAll();
            for (Trip t:trips)
            {
                if(t.getCityFrom().equals(p1) && t.getCityTo().equals(p2)){}
                else{
                    trips.remove(t);
                }
            }
        return new RestResponse(trips);
    }

}
