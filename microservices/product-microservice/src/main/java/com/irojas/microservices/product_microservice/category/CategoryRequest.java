package com.irojas.microservices.product_microservice.category;

import jakarta.validation.constraints.NotNull;

public record CategoryRequest(
    Integer id,
    @NotNull(message = "Category name is required")
    String name,
    String description
) {

}
