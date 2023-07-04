package com.example.Api.service;

import com.example.Api.model.Product;

import java.util.List;

public interface ProductService {
    // Save an Product
    Product addProduct(Product product);

    // Get Products
    List<Product> getAllProducts();

    // Get one Product
    Product findById(Integer id);

    // Update Product
    Product updateProduct(Product product);

    // Delete Product
    Boolean deleteById(Integer id);
}
