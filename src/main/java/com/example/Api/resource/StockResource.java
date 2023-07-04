package com.example.Api.resource;

import com.example.Api.model.Stock;
import com.example.Api.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/Stock")
public class StockResource {
    private final StockService stockService;

    @GetMapping
    public ResponseEntity<List<Stock>> getStocks () {
        return ResponseEntity.ok(stockService.getAllStock());
    }

    @GetMapping("{id}")
    public ResponseEntity<Stock> getStock (@PathVariable("id") Integer id) {
        return ResponseEntity.ok(stockService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Stock> addStock (@RequestBody Stock stock) {
        //stock.setId(stockService.getAllStock().size() + 1);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        stock.setUpdatetAt(dtf.format(now)+"");
        return ResponseEntity.created(getLocation(stock.getId())).body(stockService.addStack(stock));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteStock  (@PathVariable("id") Integer id) {
        return ResponseEntity.ok(stockService.deleteById(id));
    }

    // Assignment
    @PutMapping
    public ResponseEntity<Stock> updateStock(@RequestBody Stock stock) {
        Stock updatedStock = stockService.updateStock(stock);
        return ResponseEntity.ok(updatedStock);
    }

    protected static URI getLocation(Integer id) {
        return fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }
}
