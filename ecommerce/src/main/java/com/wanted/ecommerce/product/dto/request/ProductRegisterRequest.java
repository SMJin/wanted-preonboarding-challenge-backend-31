package com.wanted.ecommerce.product.dto.request;

import lombok.Getter;

@Getter
public class ProductRegisterRequest {
    private String name;
    private String slug;
    private String shortDescription;
    private String fullDescription;
    private int sellerId;
    private int brandId;
}
