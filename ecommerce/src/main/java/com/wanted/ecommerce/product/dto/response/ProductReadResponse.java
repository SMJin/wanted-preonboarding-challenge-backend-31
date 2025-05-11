package com.wanted.ecommerce.product.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ProductReadResponse {
    private int id;
    private String name;
    private String slug;
    private String shortDescription;
    private String fullDescription;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private int sellerId;
    private int brandId;
    private String status;
}
