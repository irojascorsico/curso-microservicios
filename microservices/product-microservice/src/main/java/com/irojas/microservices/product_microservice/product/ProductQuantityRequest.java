package com.irojas.microservices.product_microservice.product;

import jakarta.validation.constraints.NotNull;

public record ProductQuantityRequest(
    @NotNull(message = "Product ID cannot be null")
    Integer productId,
    @NotNull(message = "Quantity cannot be null")
    Integer quantity
) {

}
