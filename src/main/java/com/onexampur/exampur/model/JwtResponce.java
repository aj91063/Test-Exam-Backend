package com.onexampur.exampur.model;

public class JwtResponce {
    private String token;

    public JwtResponce(String token) {
        this.token = token;
    }

    public JwtResponce() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
