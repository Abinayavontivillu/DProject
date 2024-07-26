package com.example.product.demoprojectproduct.Repository;

import com.example.product.demoprojectproduct.Model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order,String> {

}
