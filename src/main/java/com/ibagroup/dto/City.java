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
    private String cityFrom;

    public City(String cityFrom) {
        this.cityFrom = cityFrom;
    }
    public  City(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityFrom='" + cityFrom + '\'' +
                '}';
    }
}


