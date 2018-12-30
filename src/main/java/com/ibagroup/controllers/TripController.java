package com.ibagroup.controllers;

import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibagroup.dto.RestResponse;
import com.ibagroup.dto.Trip;
import com.ibagroup.services.ITripService;

@RestController
@RequestMapping("/trips")
public class TripController {
    private final ITripService service;

    private TripController(ITripService itrip) {
        this.service = itrip;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Response findById(@PathVariable("id") Long id) {
        return Response.ok(new RestResponse(service.findById(id))).build();

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

}
