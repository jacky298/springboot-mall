package com.jacky298.springbootmall.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class User {
    Integer userId;
    @JsonProperty("e_mail")
    String email;
    @JsonIgnore
    String password;
    Date createdDate;
    Date lastModefiedDate;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModefiedDate() {
        return lastModefiedDate;
    }

    public void setLastModefiedDate(Date lastModefiedDate) {
        this.lastModefiedDate = lastModefiedDate;
    }
}
