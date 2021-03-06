package com.ibagroup.services;

import java.util.List;
import java.util.Optional;

import com.ibagroup.dto.Inscription;

/**
 * @author DubininaE
 */
public interface IInscriptionService {
    Long save(Inscription newInscription);

    Optional<Inscription> findById(Long id);

    void deleteById(Long id);

    List<Inscription> findAll();
}
