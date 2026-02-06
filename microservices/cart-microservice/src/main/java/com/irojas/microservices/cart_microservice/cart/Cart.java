package com.irojas.microservices.cart_microservice.cart;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.irojas.microservices.cart_microservice.cartItem.CartItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document
public class Cart {
    @Id
    private String id;
    private String customerId;
    private List<CartItem> items; 
}
