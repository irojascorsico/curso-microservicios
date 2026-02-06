package com.irojas.microservices.cart_microservice.cartItem;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/{customerId}/cart/items")
@RequiredArgsConstructor
public class CartItemController {

   private final CartItemService cartItemService;

   @PostMapping()
   public ResponseEntity<String> addItemToCart(@PathVariable("customerId") String customerId, @Valid @RequestBody CartItemRequest cartItemRequest) {
       return ResponseEntity.ok( cartItemService.addItemToCart(customerId, cartItemRequest));
       
   }

   @PutMapping()
   public ResponseEntity<Void> updateItemFromCart(@PathVariable("customerId") String customerId, @Valid @RequestBody CartItemRequest cartItemRequest) {
      cartItemService.updateItemFromCart(customerId, cartItemRequest);
      return ResponseEntity.accepted().build();
   }

   @DeleteMapping("/{productId}")
   public ResponseEntity<Void> removeItemFromCart(@PathVariable("customerId") String customerId, @PathVariable("productId") Integer productId) {
      cartItemService.removeItemFromCart(customerId, productId);
      return ResponseEntity.accepted().build();
   }
}
