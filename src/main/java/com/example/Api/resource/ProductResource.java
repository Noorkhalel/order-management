package com.example.Api.resource;

import com.example.Api.model.Product;
import com.example.Api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
//@RequiredArgsConstructor
@RequestMapping(path = "/api/product")
public class ProductResource {
    private final ProductService productService;

    public ProductResource(@Qualifier(value = "mySQLProductService")ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public ResponseEntity<List<Product>> getProducts () {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct (@PathVariable("id") Integer id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Product> addProduct (@RequestBody Product product) {
        //product.setId(productService.getAllProducts().size() + 1);
        return ResponseEntity.created(getLocation(product.getId())).body(productService.addProduct(product));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteProduct (@PathVariable("id") Integer id) {
        return ResponseEntity.ok(productService.deleteById(id));
    }

    // Assignment
    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(product);
        return ResponseEntity.ok(updatedProduct);
    }
    protected static URI getLocation(Integer id) {
        return fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }
}
