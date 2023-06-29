package com.example.restfulapi.service;

import com.example.restfulapi.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductService {

    ResponseEntity getAll();

    ResponseEntity<Product> detail(Integer id);

    ResponseEntity<Product> create(Product product);

    ResponseEntity<Product> update(Integer id, Product product);

    ResponseEntity<Void> deleteProduct(Integer id);
}
