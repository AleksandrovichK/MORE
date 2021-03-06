package com.ibagroup.controllers;

import java.sql.Time;
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
                .map(Trip -> new ResponseEntity<>(new RestResponse(Trip), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(new RestResponse(), HttpStatus.NOT_FOUND));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity save(@RequestBody Trip Trip) {
        Long result = service.save(Trip);

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

    @RequestMapping(method = RequestMethod.GET, value = "/cheap-order")
    public RestResponse findCheapestById(@RequestParam Long p1, @RequestParam Long p2) {
        return new RestResponse(this.service.findCheapest(p1, p2));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/transport")
    public RestResponse findCheapestByTransport(@RequestParam Long id1,
            @RequestParam Long id2, @RequestParam String transport) {
        return new RestResponse(this.service.findByTransport(id1, id2, transport));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/time")
    public RestResponse findCheapestByTime(@RequestParam Long id1, @RequestParam Long id2,
            @RequestParam Time starttime, @RequestParam Time endtime) {
        return new RestResponse(this.service.findByTime(id1, id2, starttime, endtime));
    }
}
