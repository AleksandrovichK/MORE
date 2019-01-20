package com.ibagroup.services.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibagroup.dao.ITripDao;
import com.ibagroup.dto.Trip;
import com.ibagroup.services.ITripService;

/**
 * @author DubininaE
 */
@Service
@Transactional
public class TripService implements ITripService {
    private final ITripDao dao;

    @Autowired
    public TripService(ITripDao dao) {
        this.dao = dao;
    }

    @Override
    public Optional<Trip> findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public Long save(Trip newTrip) {
        return dao.save(newTrip).getId();
    }

    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Override
    public List<Trip> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Trip> findCheapest(Long id1, Long id2) {
        List<Trip> trips = dao.findAll();
        for (Trip trip : trips) {
            if (!(trip.getCityFrom().equals(id1) && trip.getCityTo().equals(id2))) {
                trips.remove(trip);
            }
        }
        trips.sort(Comparator.comparing(Trip::getCost));
        return trips;
    }

    @Override
    public List<Trip> findByTransport(Long id1, Long id2, String transport) {
        List<Trip> trips = dao.findAll();
        for (Trip trip : trips) {
            if (!(trip.getCityFrom().equals(id1) && trip.getCityTo().equals(id2) && trip.getTransport().equals(transport))) {
                trips.remove(trip);
            }
        }
        trips.sort(Comparator.comparing(Trip::getCost));
        return trips;
    }
}
