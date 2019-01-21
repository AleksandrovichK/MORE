package com.ibagroup.services;

import java.sql.Time;
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

    List<Trip> findAll();

    List<Trip> findCheapest(Long id1, Long id2);

    List<Trip> findByTransport(Long id1, Long id2, String transport);

    List<Trip> findByTime(Long id1, Long id2, Time strartTime, Time endTime);
}
