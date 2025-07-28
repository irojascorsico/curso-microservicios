package com.irojas.microservices.product_microservice.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CategoryException extends RuntimeException {
    private final String message;
}
