package com.example.product.demoprojectproduct.Model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "carts")
public class Cart {

    @Id
    private String cartId;

    private String userId;

    @DBRef
    private List<CartItem> items;

    private double cartTotal;

    private Date createdAt;

    private Date updatedAt;

    private String status;


}
