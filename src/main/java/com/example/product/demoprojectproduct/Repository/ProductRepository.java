package com.example.product.demoprojectproduct.Repository;


import com.example.product.demoprojectproduct.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {
    Page<Product> findAll(Pageable pageable);
}


