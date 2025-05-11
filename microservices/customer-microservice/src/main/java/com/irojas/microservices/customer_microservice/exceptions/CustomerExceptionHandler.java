package com.irojas.microservices.customer_microservice.exceptions;

import java.util.HashMap;

import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.irojas.microservices.common_exceptions.ErrorResponse;
import com.irojas.microservices.common_exceptions.GlobalExceptionHandler;

@RestControllerAdvice(basePackages = "com.irojas.microservices.customer_microservice")
@Primary
public class CustomerExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handle (CustomerNotFoundException exception)
    {
      
        var errors = new HashMap<String, String>();
        var fieldName = "customer";
        errors.put(fieldName, exception.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors)); 

    }

}
