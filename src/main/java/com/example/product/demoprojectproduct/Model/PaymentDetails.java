package com.example.product.demoprojectproduct.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "paymentDetails")
public class PaymentDetails {


        @Id
        private String paymentId;
        @DBRef
        private Order order;
        @DBRef
        private User user;
        private double amount;
        private double tax;
        private double shippingCharges;
        private String paymentMethod;
        private String paymentStatus;
        private Date paymentDateAndTime;



}
