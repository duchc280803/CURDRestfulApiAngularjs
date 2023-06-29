package com.example.restfulapi.service.impl;

import com.example.restfulapi.entity.Product;
import com.example.restfulapi.repository.ProductRepository;
import com.example.restfulapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity getAll() {
        return new ResponseEntity(productRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Product> detail(Integer id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null){
            return new ResponseEntity<>(product, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Product> create(Product product) {
        return new ResponseEntity<>(productRepository.save(product),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Product> update(Integer id, Product product) {
        Product existingProduct  = productRepository.findById(id).orElse(null);
        if (existingProduct != null){
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setStatus(product.getStatus());
            productRepository.save(existingProduct);
            return new ResponseEntity<>(existingProduct, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Void> deleteProduct(Integer id) {
        productRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
