package com.nightfury.farmersmarket.exception_handlers;

import com.nightfury.farmersmarket.exception_handlers.APIExceptions.APIException;
import com.nightfury.farmersmarket.exception_handlers.APIExceptions.APIExceptionBody;
import com.nightfury.farmersmarket.exception_handlers.ServiceExceptions.ServiceException;
import com.nightfury.farmersmarket.exception_handlers.ServiceExceptions.ServiceExceptionBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {APIException.class})
    public ResponseEntity<Object> handleAPIException(APIException e) {
        APIExceptionBody apiException = new APIExceptionBody(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now());
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ServiceException.class})
    public ResponseEntity<Object> handleServiceException(ServiceException e) {
        ServiceExceptionBody serviceException = new ServiceExceptionBody(
                e.getMessage(),
                e.getHttpStatus(),
                ZonedDateTime.now());
        return new ResponseEntity<>(serviceException, e.getHttpStatus());
    }

}
