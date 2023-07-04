package com.example.Api.repository;

import com.example.Api.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaStockRepository extends JpaRepository<Stock, Integer> {
    // Define more if need be
}
