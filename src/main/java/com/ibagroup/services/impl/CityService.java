package com.ibagroup.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ibagroup.dao.ICityDao;
import com.ibagroup.dao.IInscriptionDao;
import com.ibagroup.dto.City;
import com.ibagroup.dto.Inscription;

/**
 * @author DubininaE
 */
public class CityService {
    private final ICityDao dao;

    @Autowired
    public CityService(ICityDao dao) {
        this.dao = dao;
    }

    public Optional<City> findById(Long id) {
        return dao.findById(id);
    }

    public Long save(City newCity) {
        return dao.save(newCity).getId();
    }

    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    public List<City> findAll() {
        return dao.findAll();
    }
}
