package com.ibagroup.services;

import java.util.List;
import java.util.Optional;

import com.ibagroup.dto.City;

/**
 * @author DubininaE
 */
public interface ICityService {
    Long save(City newInscription);

    Optional<City> findById(Long id);

    void deleteById(Long id);

    public List<City> findAll();
}
