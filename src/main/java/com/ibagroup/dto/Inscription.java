package com.ibagroup.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author DubininaE
 */
@Entity
@Table(name="inscriptions")
public class Inscription {
    @Id
    @Column(name = "name", length = 20)
    private String name;
    @Column(name = "property", length = 20)
    private String property;

    public Inscription(){}
    public Inscription(String name, String property) {
        this.name = name;
        this.property = property;
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
