package com.wanted.ecommerce.product.domain.status;

public enum ProductStatus {
    SELLING(0)
    , SOLD_OUT(1)
    , DELETED(2)
    ;

    ProductStatus(int index) {}
}
