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
 * @author AleksandrovichK
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO  )
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "USERNAME", length = 256, nullable = false)
    private String username;
    @Column(name = "PASSWORD", length = 64, nullable = false)
    private String password;
    @Column(name = "EMAIL", length = 64)
    private String email;
    @Column(name = "BALANCE", length = 10)
    private BigDecimal balance;
    @Temporal(TemporalType.DATE)
    @Column(name = "REG_DATE")
    private Date registrationDate;
    @Column(name = "USER_TYPE_ID", length = 10)
    private Short userTypeId;
    @Column(name = "IS_DELETED_FLAG")
    private Boolean isDeleted;

    public User() {
    }

    public User(Long id, String username, String email, String password, Date registrationDate, BigDecimal balance, Short userTypeId,
            Boolean isDeleted) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
        this.balance = balance;
        this.userTypeId = userTypeId;
        this.isDeleted = isDeleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Short getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Short userTypeId) {
        this.userTypeId = userTypeId;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
