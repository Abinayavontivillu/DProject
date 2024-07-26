package com.example.product.demoprojectproduct.Repository;

import com.example.product.demoprojectproduct.Model.PaymentDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentDetailsRepository extends MongoRepository<PaymentDetails,String> {
}
