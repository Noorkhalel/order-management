package com.example.Api.resource;

import com.example.Api.model.Order;
import com.example.Api.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/Order")
public class OrderResource {
    private final OrderService orderService;
    @GetMapping
    public ResponseEntity<List<Order>> getOrder () {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("{id}")
    public ResponseEntity<Order> getOrder (@PathVariable("id") Integer id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Order> addOrder (@RequestBody Order order) {
        //Order.setId(OrderService.getAllOrder().size() + 1);
        return ResponseEntity.created(getLocation(order.getId())).body(orderService.addOrder(order));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteOrder  (@PathVariable("id") Integer id) {
        return ResponseEntity.ok(orderService.deleteById(id));
    }

    // Assignment
    @PutMapping
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
        Order updatedOrder = orderService.updateOrder(order);
        return ResponseEntity.ok(updatedOrder);
    }

    protected static URI getLocation(Integer id) {
        return fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }
}
