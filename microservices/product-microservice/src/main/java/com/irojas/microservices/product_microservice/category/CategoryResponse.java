package com.irojas.microservices.product_microservice.category;

import java.util.List;

import com.irojas.microservices.product_microservice.product.ProductResponse;

public record CategoryResponse(
    Integer id,
    String name,
    String description,
    List<ProductResponse> products
) {

}
