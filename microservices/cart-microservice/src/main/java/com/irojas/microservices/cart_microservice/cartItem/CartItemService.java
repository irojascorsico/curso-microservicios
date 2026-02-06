package com.irojas.microservices.cart_microservice.cartItem;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.irojas.microservices.cart_microservice.cart.Cart;
import com.irojas.microservices.cart_microservice.cart.CartRepository;
import com.irojas.microservices.cart_microservice.customer.CustomerClient;
import com.irojas.microservices.cart_microservice.customer.CustomerResponse;
import com.irojas.microservices.cart_microservice.exceptions.CartException;
import com.irojas.microservices.cart_microservice.product.ProductClient;
import com.irojas.microservices.cart_microservice.product.ProductResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartItemService {

    private final CartRepository cartRepository;
    private final CustomerClient customerClient;    
    private final ProductClient productClient;

    public String addItemToCart(String customerId, CartItemRequest cartItemRequest) {

        CustomerResponse customerResponse= customerClient.getCustomerById(customerId)
            .orElseThrow(() -> new CartException("Customer whit id " + customerId + " does not exist"));

        ProductResponse productResponse = productClient.getProductById(cartItemRequest.productId())
            .orElseThrow(() -> new CartException("Product whit id " + cartItemRequest.productId() + " does not exist"));
           
        if (productResponse.stock() < cartItemRequest.quantity()) {
            throw new CartException("Product whit id " + cartItemRequest.productId() + " does not have enough stock");
        }

        Cart cart = cartRepository.findByCustomerId(customerResponse.id())
            .orElse(Cart.builder()
                .customerId(customerId)
                .items(new ArrayList<>())
                .build()
            );

        boolean productExists = cart.getItems().stream()
            .anyMatch(item -> item.getProductId().equals(cartItemRequest.productId()));
            
        if (productExists) {
            throw new CartException("Product whit id " + cartItemRequest.productId() + " is already in the cart");
        }

        cart.getItems().add(
            CartItem.builder()
                .productId(cartItemRequest.productId())
                .quantity(cartItemRequest.quantity())
                .build()
        );

        cartRepository.save(cart);

        return cart.getId();
    }

    public void updateItemFromCart(String customerId, CartItemRequest cartItemRequest) {

        Cart cart = cartRepository.findByCustomerId(customerId)
            .orElseThrow(() -> new CartException("Cart for customer with id " + customerId + " does not exist"));

        CartItem itemToUpdate = cart.getItems().stream()
            .filter(item -> item.getProductId()== cartItemRequest.productId())
            .findFirst()
            .orElseThrow(() -> new CartException("Product with id " + cartItemRequest.productId() + " is not in the cart"));
    
        if (productClient.getProductById(cartItemRequest.productId()).get().stock() < cartItemRequest.quantity()) {
            throw new CartException("Product whit id " + cartItemRequest.productId() + " does not have enough stock");
        }

        itemToUpdate.setQuantity(cartItemRequest.quantity());
        
        cartRepository.save(cart);
    }

    public void removeItemFromCart(String customerId, Integer productId) {
        Cart cart = cartRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new CartException("Cart for customer with id " + customerId + " does not exist"));
        
        CartItem itemToRemove = cart.getItems().stream()
            .filter(item -> item.getProductId()== productId)
            .findFirst()
            .orElseThrow(() -> new CartException("Product with id " + productId + " is not in the cart"));

        cart.getItems().remove(itemToRemove);
        cartRepository.save(cart);
      
    }
}
