package com.example.Api.service.impl;

import com.example.Api.model.ProductOrder;
import com.example.Api.repository.JpaProductOrderRepository;
import com.example.Api.service.ProductOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Qualifier(value = "mySQLProductOrderService")
public class JpaProductOrderServiceImpl implements ProductOrderService {
    private final JpaProductOrderRepository jpaProductOrderRepository;
    @Override
    public ProductOrder addProductOrder(ProductOrder productOrder) {
        return jpaProductOrderRepository.save(productOrder);
    }

    @Override
    public List<ProductOrder> getAllProductOrders() {
        return jpaProductOrderRepository.findAll();
    }

    @Override
    public ProductOrder findById(Integer id) {
        return jpaProductOrderRepository.findById(id).get();
    }

    @Override
    public ProductOrder updateProductOrder(ProductOrder productOrder) {
        // Check if the product exists
        if (jpaProductOrderRepository.existsById(productOrder.getId())) {
            return jpaProductOrderRepository.save(productOrder);
        } else {
            throw new IllegalArgumentException("Product Order does not exist");
        }
    }

    @Override
    public Boolean deleteById(Integer id) {
        jpaProductOrderRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
