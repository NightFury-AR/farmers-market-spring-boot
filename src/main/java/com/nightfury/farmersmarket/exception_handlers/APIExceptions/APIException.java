package com.nightfury.farmersmarket.exception_handlers.APIExceptions;


public class APIException extends RuntimeException {

    public APIException(String message) {
        super(message);
    }

    public APIException(String message, Throwable cause) {
        super(message, cause);
    }

}
