package com.fse0.microservice.loginservice.helper;

import com.fse0.microservice.loginservice.model.JWTResponse;

public class ResponseDetail {
    private JWTResponse jwtResponse;
    private String userName;

    public ResponseDetail() {
    }

    public ResponseDetail(JWTResponse jwtResponse, String userName) {
        this.jwtResponse = jwtResponse;
        this.userName = userName;
    }

    public JWTResponse getJwtResponse() {
        return jwtResponse;
    }

    public void setJwtResponse(JWTResponse jwtResponse) {
        this.jwtResponse = jwtResponse;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
