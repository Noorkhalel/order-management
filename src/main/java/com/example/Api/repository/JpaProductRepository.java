package com.example.Api.repository;

import com.example.Api.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductRepository extends JpaRepository<Product, Integer> {
    // Define more if need be
}