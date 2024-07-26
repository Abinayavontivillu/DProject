package com.example.product.demoprojectproduct.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Document(collection="orders")
public class Order {

    @MongoId(FieldType.OBJECT_ID)
    private String orderId;
    private LocalDateTime dateAndTime;
    @JsonProperty("checkoutProducts")
    private List<CheckoutProductV0>checkoutProducts;
    private double orderValue;
     @DBRef
     private Set< User> user;
     @DBRef
    private ShippingDetails shippingDetails;
    private PaymentDetails paymentDetails;
    private DeliveryDetails deliveryDetails;



    public static class CheckoutProductV0
    {

        @JsonProperty("productId")
        private String productId;
        @JsonProperty("productName")
        private String productName;
        @JsonProperty("quantity")
        private int quantity;
        @JsonProperty("price")
        private double price;

    }




}
