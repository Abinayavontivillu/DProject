package com.example.product.demoprojectproduct.Repository;

import com.example.product.demoprojectproduct.Model.ShippingDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShippingDetailsRepository extends MongoRepository<ShippingDetails,String> {
}
