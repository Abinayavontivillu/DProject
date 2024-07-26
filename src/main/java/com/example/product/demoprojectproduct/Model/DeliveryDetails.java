package com.example.product.demoprojectproduct.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;

public class DeliveryDetails {
    @Id
    private String deliveryId;
    @DBRef
    private User user;
    @DBRef
    private Order order;
    private String deliveryAddress;
    private String deliveryStatus;
    private Date expectedDelivery;
    private Date deliveredOn;
    private Date shippedOn;
}
