package com.example.product.demoprojectproduct.Controller;

import com.example.product.demoprojectproduct.Model.Cart;
import com.example.product.demoprojectproduct.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    public Cart getCart(@PathVariable String userId) {
        return cartService.getCartByUserId(userId);
    }

    @PostMapping("/{userId}/items")
    public Cart addItemToCart(@PathVariable String userId, @RequestParam String productId, @RequestParam int quantity) {
        return cartService.addItemToCart(userId, productId, quantity);
    }


}
