package com.example.Api.service;

import com.example.Api.model.Customer;


import java.util.List;

public interface CustomerService {
    // Save Customer
    Customer addCustomer(Customer customer);

    // Get Order Customer
    List<Customer> getAllCustomers();

    // Get one Customer
    Customer findById(Integer id);

    // Update Customer
    Customer updateCustomer(Customer customer);

    // Delete Customer
    Boolean deleteById(Integer id);
}
