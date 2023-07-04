package com.example.Api.service.impl;

import com.example.Api.model.Customer;
import com.example.Api.repository.JpaCustomerRepository;
import com.example.Api.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Qualifier(value = "mySQLCustomerService")
public class JpaCustomerServiceImpl implements CustomerService {
    private final JpaCustomerRepository jpaCustomerRepository;
    @Override
    public Customer addCustomer(Customer customer) {
        return jpaCustomerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return jpaCustomerRepository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return jpaCustomerRepository.findById(id).get();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        // Check if the product exists
        if (jpaCustomerRepository.existsById(customer.getId())) {
            return jpaCustomerRepository.save(customer);
        } else {
            throw new IllegalArgumentException("customer does not exist");
        }
    }

    @Override
    public Boolean deleteById(Integer id) {
        jpaCustomerRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
