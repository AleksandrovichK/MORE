package com.ibagroup.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

/**
 * Not needed for a while.
 *
 * @author AleksandrovichK
 */
@Repository
public abstract class AbstractDao {

    @PersistenceContext
    private EntityManager em;

    protected Object selectSomething(Object object){
        // javax.persistence.Query query = em.createNamedQuery("SELECT * from SUBSCRIBERS");
        return null;
    }
}
