package com.example.tokenization.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TokenEntity {

    @Id
    private String token;

    private String accountNumber;

    public TokenEntity() {}

    public TokenEntity(String token, String accountNumber) {
        this.token = token;
        this.accountNumber = accountNumber;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}