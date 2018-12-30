package com.ibagroup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibagroup.dto.Trip;

/**
 * @author DubininaE
 */
public interface ITripDao extends JpaRepository<Trip, Long> {
}
