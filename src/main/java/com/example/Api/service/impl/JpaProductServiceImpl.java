package com.example.Api.service.impl;

import com.example.Api.model.Product;
import com.example.Api.repository.JpaProductRepository;
import com.example.Api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
@Qualifier(value = "mySQLProductService")
public class JpaProductServiceImpl implements ProductService {
    private final JpaProductRepository jpaProductRepository;
    @Override
    public Product addProduct(Product product) {
        return jpaProductRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return jpaProductRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return jpaProductRepository.findById(id).get();
    }

    @Override
    public Product updateProduct(Product product) {
        // Check if the product exists
        if (jpaProductRepository.existsById(product.getId())) {
            return jpaProductRepository.save(product);
        } else {
            throw new IllegalArgumentException("Product does not exist");
        }
    }

    @Override
    public Boolean deleteById(Integer id) {
        jpaProductRepository.deleteById(id);
        return Boolean.TRUE;
    }
}