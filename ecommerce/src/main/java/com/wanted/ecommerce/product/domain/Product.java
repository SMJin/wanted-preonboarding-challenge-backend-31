package com.wanted.ecommerce.product.domain;

import com.wanted.ecommerce.product.domain.status.ProductStatus;
import jakarta.persistence.*;
import lombok.Setter;

import java.time.LocalDate;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Setter
    private String slug;

    @Setter
    private String shortDescription;

    @Setter
    private String fullDescription;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private int sellerId;
    private int brandId;
    private ProductStatus status;

    public Product(String name, int sellerId, int brandId) {
        this.name = name;
        LocalDate now = LocalDate.now();
        this.createdAt = now;
        this.updatedAt = now;
        this.sellerId = sellerId;
        this.brandId = brandId;
        this.status = ProductStatus.SELLING;
    }

}
