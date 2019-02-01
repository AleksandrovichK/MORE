package com.ibagroup.dto;

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
 * @author AleksandrovichK
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "LOGIN", length = 64, nullable = false)
    private String login;
    @Column(name = "PASSWORD", length = 64, nullable = false)
    private String password;
    @Column(name = "FULLNAME", length = 256, nullable = false)
    private String fullname;
    @Column(name = "ROLE", length = 64, nullable = false)
    private String role;
    @Temporal(TemporalType.DATE)
    @Column(name = "REG_DATE")
    private Date registrationDate;
    @Column(name = "TRAVELS_COUNT", length = 5)
    private Integer travelsCount;

    public User() {
    }

    public User(String login, String password, String fullname, String role, Date registrationDate, Integer travelsCount) {
        this.login = login;
        this.password = password;
        this.fullname = fullname;
        this.role = role;
        this.registrationDate = registrationDate;
        this.travelsCount = travelsCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Integer getTravelsCount() {
        return travelsCount;
    }

    public void setTravelsCount(Integer travelsCount) {
        this.travelsCount = travelsCount;
    }
}
