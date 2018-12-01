package com.ibagroup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibagroup.dto.Inscription;

/**
 * @author DubininaE
 */
public interface InscriptionDAO extends JpaRepository<Inscription, Long> {
}
