package com.example.Api.service.impl;

import com.example.Api.model.Order;
import com.example.Api.repository.JpaOrderRepository;
import com.example.Api.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
@Qualifier(value = "mySQLOrderService")
public class JpaOrderServiceImpl implements OrderService {
    private final JpaOrderRepository jpaOrderRepository;
    @Override
    public Order addOrder(Order order) {
        return jpaOrderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return jpaOrderRepository.findAll();
    }

    @Override
    public Order findById(Integer id) {
        return jpaOrderRepository.findById(id).get();
    }

    @Override
    public Order updateOrder(Order Order) {
        // Check if the product exists
        if (jpaOrderRepository.existsById(Order.getId())) {
            return jpaOrderRepository.save(Order);
        } else {
            throw new IllegalArgumentException("Order does not exist");
        }
    }

    @Override
    public Boolean deleteById(Integer id) {
        jpaOrderRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
