package com.ibagroup.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author DubininaE
 */
@Entity
@Table(name="inscriptions")
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO  )
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", length = 20)
    private String name;
    @Column(name = "property", length = 20)
    private String property;


    public Inscription(String name, String property) {
        this.name = name;
        this.property = property;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
