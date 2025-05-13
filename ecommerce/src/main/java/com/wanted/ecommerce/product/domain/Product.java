package com.wanted.ecommerce.product.domain;

import com.wanted.ecommerce.product.domain.status.ProductStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@ToString @Getter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Setter
    private String slug;

    @Setter
    private String shortDescription;

    @Setter
    private String fullDescription;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Long sellerId;
    private Long brandId;
    private ProductStatus status;

    public Product(String name, Long sellerId, Long brandId) {
        this.name = name;
        LocalDate now = LocalDate.now();
        this.createdAt = now;
        this.updatedAt = now;
        this.sellerId = sellerId;
        this.brandId = brandId;
        this.status = ProductStatus.SELLING;
    }

}
