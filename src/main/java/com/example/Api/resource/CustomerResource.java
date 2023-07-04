package com.example.Api.resource;


import com.example.Api.model.Customer;
import com.example.Api.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/Customer")
public class CustomerResource {
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomer () {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomer (@PathVariable("id") Integer id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer (@RequestBody Customer customer) {
        //Customer.setId(customerService.getAllCustomer().size() + 1);

        return ResponseEntity.created(getLocation(customer.getId())).body(customerService.addCustomer(customer));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteCustomer (@PathVariable("id") Integer id) {
        return ResponseEntity.ok(customerService.deleteById(id));
    }

    // Assignment
    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        Customer updateCustomer = customerService.updateCustomer(customer);
        return ResponseEntity.ok(updateCustomer);
    }

    protected static URI getLocation(Integer id) {
        return fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }
}
