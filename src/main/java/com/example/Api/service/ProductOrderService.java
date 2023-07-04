package com.example.Api.service;
import com.example.Api.model.ProductOrder;
import java.util.List;

public interface ProductOrderService {
    // Save an Product Order
    ProductOrder addProductOrder(ProductOrder productOrder);

    // Get Product Orders
    List<ProductOrder> getAllProductOrders();

    // Get one Product Order
    ProductOrder findById(Integer id);

    // Update Product Order
    ProductOrder updateProductOrder(ProductOrder productOrder);

    // Delete Product Order
    Boolean deleteById(Integer id);
}
