package com.example.Api.repository;

import com.example.Api.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderRepository extends JpaRepository<Order, Integer> {
    // Define more if need be
}
