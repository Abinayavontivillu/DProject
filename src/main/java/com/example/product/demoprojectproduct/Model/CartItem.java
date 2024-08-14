package com.example.product.demoprojectproduct.Model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@Document
public class CartItem {

    @Id
    private String id;

    @DBRef
    private Product product;

    private int quantity;

    private double price;

    private double totalPrice;

    // Getters and Setters
}
