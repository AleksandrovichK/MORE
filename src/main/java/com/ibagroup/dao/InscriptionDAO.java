package com.ibagroup.dao;

import org.springframework.data.repository.CrudRepository;

import com.ibagroup.dto.Inscription;

/**
 * @author DubininaE
 */
public interface InscriptionDAO extends CrudRepository<Inscription, String> {
}
