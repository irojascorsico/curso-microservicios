package com.irojas.microservices.cart_microservice.cart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.irojas.microservices.cart_microservice.cartItem.CartItem;
import com.irojas.microservices.cart_microservice.cartItem.CartItemResponse;

@Service
public class CartMapper {

    public CartResponse toCartResponse(Cart cart) {

        List<CartItemResponse> cartItemResponses = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            cartItemResponses.add(new CartItemResponse(
                item.getProductId(),
                item.getQuantity()
            ));
        }
        
        return new CartResponse( cart.getId() , cart.getCustomerId(), cartItemResponses);
    }

}
