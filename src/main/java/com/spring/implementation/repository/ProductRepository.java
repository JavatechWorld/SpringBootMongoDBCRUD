package com.spring.implementation.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.implementation.model.Products;

public interface ProductRepository extends MongoRepository<Products, String>{

}
