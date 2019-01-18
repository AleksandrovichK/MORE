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
    private Long cityFrom;
    @Column(name = "TO_CITY", length = 20, nullable = false)
    private Long cityTo;
    @Column(name = "COST")
    private Integer cost;
    @Column(name = "TRANSPORT", length = 20)
    private String transport;
    @Column(name = "START_TIME")
    private String startTime;
    @Column(name = "END_TIME")
    private String endTime;

    public Trip() {
    }

    public Trip(Long cityFrom, Long cityTo, Integer cost, String transport, String startTime, String endTime) {
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
        this.cost = cost;
        this.transport = transport;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(Long cityFrom) {
        this.cityFrom = cityFrom;
    }

    public Long getCityTo() {
        return cityTo;
    }

    public void setCityTo(Long cityTo) {
        this.cityTo = cityTo;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", cityFrom='" + cityFrom + '\'' +
                ", cityTo='" + cityTo + '\'' +
                ", cost=" + cost +
                ", balance=" + transport +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}


