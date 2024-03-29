package com.webflux.demo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.webflux.demo.entity.Product;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> { //entity and ID
    
}
