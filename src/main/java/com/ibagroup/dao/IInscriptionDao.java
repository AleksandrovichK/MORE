package com.ibagroup.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibagroup.dto.Inscription;

/**
 * @author DubininaE
 */
@Repository
public interface IInscriptionDao extends JpaRepository<Inscription, Long> {
}
