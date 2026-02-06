package com.irojas.microservices.cart_microservice.cart;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {

    Optional<Cart> findByCustomerId(String customerId);

}
