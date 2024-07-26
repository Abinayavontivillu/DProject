package com.example.product.demoprojectproduct.Service;



import com.example.product.demoprojectproduct.Model.Product;

import com.example.product.demoprojectproduct.Repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        //logger.info("Adding new product:{}",product.getBrand());
        return productRepository.save(product);
    }

    public Product updateProduct(String id, Product product) {
        logger.info("Updating product with id: {}",id);
        if (productRepository.existsById(id)) {
            product.setId(id);
            return productRepository.save(product);
        }
        return null;
    }

    public void deleteProduct(String id) {
        logger.warn("Deleting product with id:{}",id);
        productRepository.deleteById(id);
    }
}




