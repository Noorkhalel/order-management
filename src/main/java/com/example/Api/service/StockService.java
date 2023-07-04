package com.example.Api.service;

import com.example.Api.model.Stock;

import java.util.List;

public interface StockService {
    // Save an Product
    Stock addStack(Stock stock);

    // Get Products
    List<Stock> getAllStock();

    // Get one Product
    Stock findById(Integer id);

    // Update Product
    Stock updateStock(Stock stock);

    // Delete Product
    Boolean deleteById(Integer id);
}
