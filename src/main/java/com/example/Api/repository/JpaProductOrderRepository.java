package com.example.Api.repository;

import com.example.Api.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductOrderRepository extends JpaRepository<ProductOrder, Integer> {
}
