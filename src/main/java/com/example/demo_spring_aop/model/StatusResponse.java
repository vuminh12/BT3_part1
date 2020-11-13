package com.example.demo_spring_aop.model;

public class StatusResponse {
    private boolean success;

    public StatusResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
