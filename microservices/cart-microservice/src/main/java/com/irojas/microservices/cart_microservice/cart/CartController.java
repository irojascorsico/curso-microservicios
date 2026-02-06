package com.irojas.microservices.cart_microservice.cart;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/{customerId}/cart/")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping()
    public ResponseEntity<CartResponse> getCartByCustomerId(@PathVariable("customerId") String customerId) {
        CartResponse cartResponse = cartService.getCartByCustomerId(customerId);
        return ResponseEntity.ok(cartResponse);
    }

    @DeleteMapping()
    public ResponseEntity<Void> clearCart(@PathVariable("customerId") String customerId) {
        cartService.clearCart(customerId);
        return ResponseEntity.noContent().build();
    }
   
}
