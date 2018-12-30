package com.ibagroup.services.impl;

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

    public Optional<Trip> findById(Long id) {
        return dao.findById(id);
    }

    public Long save(Trip newTrip) {
        return dao.save(newTrip).getId();
    }

    public void deleteById(Long id) {
        dao.deleteById(id);
    }
}
