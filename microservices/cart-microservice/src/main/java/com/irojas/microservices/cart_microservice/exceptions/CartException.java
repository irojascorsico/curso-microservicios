package com.irojas.microservices.cart_microservice.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CartException extends RuntimeException {
    private final String message;
}
