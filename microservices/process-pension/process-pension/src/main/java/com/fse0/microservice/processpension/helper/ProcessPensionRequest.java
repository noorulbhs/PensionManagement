package com.fse0.microservice.processpension.helper;

public class ProcessPensionRequest {
    private Integer adhaarNumber;

    public ProcessPensionRequest() {
    }

    public ProcessPensionRequest(Integer adhaarNumber) {
        this.adhaarNumber = adhaarNumber;
    }

    public Integer getAdhaarNumber() {
        return adhaarNumber;
    }

    public void setAdhaarNumber(Integer adhaarNumber) {
        this.adhaarNumber = adhaarNumber;
    }
}
