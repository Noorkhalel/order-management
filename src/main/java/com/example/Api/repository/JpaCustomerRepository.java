package com.example.Api.repository;

import com.example.Api.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCustomerRepository extends JpaRepository<Customer, Integer> {
    //
}
