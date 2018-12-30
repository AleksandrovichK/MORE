package com.ibagroup.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibagroup.dto.Trip;

/**
 * @author DubininaE
 */
@Repository
public interface ITripDao extends JpaRepository<Trip, Long> {
}
