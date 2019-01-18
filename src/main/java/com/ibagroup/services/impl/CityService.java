package com.ibagroup.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibagroup.dao.ICityDao;
import com.ibagroup.dto.City;
import com.ibagroup.services.ICityService;

/**
 * @author DubininaE
 */
@Service
@Transactional
public class CityService implements ICityService {
    private final ICityDao dao;

    @Autowired
    public CityService(ICityDao dao) {
        this.dao = dao;
    }


    @Override
    public Optional<City> findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public Long save(City newCity) {
        return dao.save(newCity).getId();
    }

    @Override
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    @Override
    public List<City> findAll() {
        return dao.findAll();
    }
}
