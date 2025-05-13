package com.wanted.ecommerce.product.dto.request;

import com.wanted.ecommerce.common.domain.status.YnType;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class ProductSearchRequest {
    private List<Long> tagIds;
    private LocalDate createdAt;
    private int sellerId;
    private int brandId;
    private int moreThanPrice;
    private int lessThanPrice;
    private int categoryId;
    private YnType hasStock;
}
