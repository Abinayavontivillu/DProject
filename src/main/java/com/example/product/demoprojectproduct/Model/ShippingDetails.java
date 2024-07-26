package com.example.product.demoprojectproduct.Model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.Date;


@Data
@Document(collection="shippingDetails")
public class ShippingDetails {
    @MongoId(FieldType.OBJECT_ID)
    private String ShippingId;
    @DBRef
    private Order order;
    private String status;
    private LocalDateTime dateAndTime;
    private String shippedBy;
    private String shippedThru;
    private String courierTrackingId;
}
