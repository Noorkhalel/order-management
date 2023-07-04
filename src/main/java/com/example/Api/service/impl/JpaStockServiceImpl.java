package com.example.Api.service.impl;

import com.example.Api.model.Stock;
import com.example.Api.repository.JpaStockRepository;
import com.example.Api.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Qualifier(value = "mySQLStockService")
public class JpaStockServiceImpl implements StockService {
    private final JpaStockRepository jpaStockRepository;
    @Override
    public Stock addStack(Stock stock) {
        return jpaStockRepository.save(stock);
    }

    @Override
    public List<Stock> getAllStock() {
        return jpaStockRepository.findAll();
    }

    @Override
    public Stock findById(Integer id) {
        return jpaStockRepository.findById(id).get();
    }

    @Override
    public Stock updateStock(Stock stock) {
        // Check if the product exists
        if (jpaStockRepository.existsById(stock.getId())) {
            return jpaStockRepository.save(stock);
        } else {
            throw new IllegalArgumentException("Stock does not exist");
        }
    }

    @Override
    public Boolean deleteById(Integer id) {
        jpaStockRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
