package com.example.Api.resource;

import com.example.Api.model.ProductOrder;
import com.example.Api.service.ProductOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/productOrder")
public class ProductOrderResource {
    private final ProductOrderService productOrderService;
//    public ProductOrderResource(@Qualifier(value = "mySQLProductOrderService") ProductOrderService productOrderService) {
//        this.productOrderService = productOrderService;
//    }
    @GetMapping
    public ResponseEntity<List<ProductOrder>> getOrderProducts () {
        return ResponseEntity.ok(productOrderService.getAllProductOrders());
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductOrder> getOrderProduct (@PathVariable("id") Integer id) {
        return ResponseEntity.ok(productOrderService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProductOrder> addProductOrder (@RequestBody ProductOrder productOrder) {
//        productOrder.setId(productOrderService.getAllProductOrders().size() + 1);
        return ResponseEntity.created(getLocation(productOrder.getId())).body(productOrderService.addProductOrder(productOrder));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteProductOrder (@PathVariable("id") Integer id) {
        return ResponseEntity.ok(productOrderService.deleteById(id));
    }

    // Assignment
    @PutMapping
    public ResponseEntity<ProductOrder> updateProductOrder(@RequestBody ProductOrder productOrder) {
        ProductOrder updateProductOrder = productOrderService.updateProductOrder(productOrder);
        return ResponseEntity.ok(updateProductOrder);
    }


    protected static URI getLocation(Integer id) {
        return fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }
}
