package com.authentication.model;

import java.time.LocalDateTime;
public class tokenModel {
    private int id;
    private String token;
    private LocalDateTime createdAt;
    private LocalDateTime expiration;

    public tokenModel(String token, LocalDateTime createdAt, LocalDateTime expiration) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiration = expiration;
    }

    public tokenModel() {
        this.token = "";
        this.createdAt = LocalDateTime.now();
        this.expiration = LocalDateTime.now().plusHours(1);
    }

    public String getToken() {
        return token;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getExpiration() {
        return expiration;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setExpiration(LocalDateTime expiration) {
        this.expiration = expiration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}