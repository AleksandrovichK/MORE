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
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "FRM", length = 20, nullable = false)
    private Long from_city;
    @Column(name = "TO_CITY", length = 20, nullable = false)
    private Long to_city;
    @Column(name = "COST")
    private Integer cost;
    @Column(name = "TRANSPORT", length = 20)
    private String transport;
    @Column(name = "START_TIME")
    private String starttime;
    @Column(name = "END_TIME")
    private String endtime;

    public Trip() {
    }

    public Trip(Long from_city, Long to_city, Integer cost, String transport, String starttime, String endtime) {
        this.from_city = from_city;
        this.to_city = to_city;
        this.cost = cost;
        this.transport = transport;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFrom_city() {
        return from_city;
    }

    public void setFrom_city(Long from_city) {
        this.from_city = from_city;
    }

    public Long getTo_city() {
        return to_city;
    }

    public void setTo_city(Long to_city) {
        this.to_city = to_city;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", from_city='" + from_city + '\'' +
                ", to_city='" + to_city + '\'' +
                ", cost=" + cost +
                ", balance=" + transport +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                '}';
    }
}


