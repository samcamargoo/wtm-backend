package com.wtmrio.api.createuser;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CleanPassword {

    private String password;

    public CleanPassword(String password) {
        this.password = password;
    }

    public String encrypt() {
        return new BCryptPasswordEncoder().encode(password);
    }
}
