package com.ibagroup.dto;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author DubininaE
 */
@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "CITY", length = 20, nullable = false)
    private String from_city;

    public City(String from_city) {
        this.from_city = from_city;
    }
    public  City(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom_city() {
        return from_city;
    }

    public void setFrom_city(String from_city) {
        this.from_city = from_city;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", from_city='" + from_city + '\'' +
                '}';
    }
}


