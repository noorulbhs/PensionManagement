package com.fse0.microservice.loginservice.model;

public class JWTResponse {
    private String token;
    private String userName;

    public JWTResponse() {
    }

    public JWTResponse(String token, String userName) {
        this.userName=userName;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
