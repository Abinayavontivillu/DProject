package com.example.product.demoprojectproduct.Repository;

import com.example.product.demoprojectproduct.Model.DeliveryDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeliveryDetailsRepository extends MongoRepository<DeliveryDetails,String> {
}
