package com.example.Api.service;

import com.example.Api.model.Order;


import java.util.List;

public interface OrderService {
    // Save an Order
    Order addOrder(Order order);

    // Get Order Orders
    List<Order> getAllOrders();

    // Get one Order
    Order findById(Integer id);

    // Update Order
    Order updateOrder(Order Order);

    // Delete Order
    Boolean deleteById(Integer id);
}
