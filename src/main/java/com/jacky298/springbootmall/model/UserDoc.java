package com.jacky298.springbootmall.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class UserDoc {
    @NotNull
    @Email
    String email;
    @NotNull
    String password;

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
}
