package com.ibagroup.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibagroup.dao.IInscriptionDao;
import com.ibagroup.dao.IUserDao;
import com.ibagroup.dto.Inscription;
import com.ibagroup.dto.User;
import com.ibagroup.services.IInscriptionService;

/**
 * @author DubininaE
 */
@Service
@Transactional
public class InscriptionService implements IInscriptionService {
    private final IInscriptionDao dao;

    @Autowired
    public InscriptionService(IInscriptionDao dao) {
        this.dao = dao;
    }

    public Optional<Inscription> findById(Long id) {
        return dao.findById(id);
    }

    public Long save(Inscription newInscription) {
        return dao.save(newInscription).getId();
    }

    public void deleteById(Long id) {
        dao.deleteById(id);
    }

    public List<Inscription> findAll() {
        return dao.findAll();
    }
}
