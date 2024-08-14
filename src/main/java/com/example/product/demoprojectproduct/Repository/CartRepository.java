package com.example.product.demoprojectproduct.Repository;


import com.example.product.demoprojectproduct.Model.Cart;
import com.example.product.demoprojectproduct.Model.CartItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface CartRepository extends MongoRepository<Cart, String> {
    Optional<Cart> findByuserId(String userId);
}
