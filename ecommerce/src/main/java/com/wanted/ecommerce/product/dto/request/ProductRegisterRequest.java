package com.wanted.ecommerce.product.dto.request;

import com.wanted.ecommerce.tag.dto.TagSummary;
import lombok.Getter;

import java.util.List;

@Getter
public class ProductRegisterRequest {
    private String name;
    private String slug;
    private String shortDescription;
    private String fullDescription;
    private Long sellerId;
    private Long brandId;

    private List<Long> tagIds;
}
