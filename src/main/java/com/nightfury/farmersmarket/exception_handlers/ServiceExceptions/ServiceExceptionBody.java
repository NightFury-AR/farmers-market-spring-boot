package com.nightfury.farmersmarket.exception_handlers.ServiceExceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ServiceExceptionBody {

    private String message;
    private HttpStatus status;
    private ZonedDateTime timeStamp;

    public ServiceExceptionBody(String message, HttpStatus status, ZonedDateTime timeStamp) {
        this.message = message;
        this.status = status;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(ZonedDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
