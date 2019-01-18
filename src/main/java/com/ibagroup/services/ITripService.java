package com.ibagroup.services;

import java.util.List;
import java.util.Optional;

import com.ibagroup.dto.Trip;

/**
 * @author DubininaE
 */
public interface ITripService {
    Long save(Trip newTrip);

    Optional<Trip> findById(Long id);

    void deleteById(Long id);

    public List<Trip>findAll();
}
