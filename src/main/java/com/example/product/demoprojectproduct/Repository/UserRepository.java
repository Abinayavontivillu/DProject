package com.example.product.demoprojectproduct.Repository;

import com.example.product.demoprojectproduct.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
