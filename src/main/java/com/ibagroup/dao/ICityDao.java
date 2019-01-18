package com.ibagroup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibagroup.dto.City;

/**
 * @author DubininaE
 */
public interface ICityDao extends JpaRepository<City, Long> {
}
