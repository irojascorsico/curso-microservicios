package com.irojas.microservices.cart_microservice.exceptions;

import java.util.HashMap;

import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.irojas.microservices.common_exceptions.ErrorResponse;
import com.irojas.microservices.common_exceptions.GlobalExceptionHandler;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice(basePackages = "com.irojas.microservices.cart_microservice")
@Primary
@Slf4j
public class CartExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(CartException.class)
    public ResponseEntity<ErrorResponse> handle (CartException exception)
    {
      
        var errors = new HashMap<String, String>();
        var fieldName = "cart";

        errors.put(fieldName, exception.getMessage());
        
        log.warn("Cart error: {}", exception.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors)); 

    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ErrorResponse> handleFeignException(FeignException exception) {
        var errors = new HashMap<String, String>();
        var fieldName = "Error communicating with microservice";

        errors.put(fieldName, exception.getMessage());
        
        log.warn("Error communicating with microservice: {}", exception.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors)); 
    }

}

