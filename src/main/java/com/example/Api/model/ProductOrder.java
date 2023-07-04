package com.example.Api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductOrder {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer productId;
    private Integer orderId;
    private Integer quantity;
    private Double price;
    private Double vat;
}