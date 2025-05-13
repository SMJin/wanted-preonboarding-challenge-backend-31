package com.wanted.ecommerce.product.dto.response;

import com.wanted.ecommerce.tag.dto.TagSummary;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class ProductReadResponse {
    private Long productId;
    private String name;
    private String slug;
    private String shortDescription;
    private String fullDescription;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Long sellerId;
    private Long brandId;
    private String status;

    private List<TagSummary> tags;
}
