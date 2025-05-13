package com.wanted.ecommerce.product.dto.response;

import com.wanted.ecommerce.common.translator.Translator;
import com.wanted.ecommerce.product.domain.Product;
import com.wanted.ecommerce.tag.domain.Tag;
import com.wanted.ecommerce.tag.dto.TagSummaryTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductReadResponseTranslator implements Translator<Product, ProductReadResponse> {

    private final TagSummaryTranslator tagSummaryTranslator;

    @Override
    public Product toEntity(ProductReadResponse productReadResponse) {
        Product product = new Product(
                productReadResponse.getName(),
                productReadResponse.getSellerId(),
                productReadResponse.getBrandId()
        );
        product.setSlug(productReadResponse.getSlug());
        product.setShortDescription(productReadResponse.getShortDescription());
        product.setFullDescription(productReadResponse.getFullDescription());
        return product;
    }

    @Override
    public ProductReadResponse toDto(Product product) {
        return new ProductReadResponse(
                product.getId(),
                product.getName(),
                product.getSlug(),
                product.getShortDescription(),
                product.getFullDescription(),
                product.getCreatedAt(),
                product.getUpdatedAt(),
                product.getSellerId(),
                product.getBrandId(),
                product.getStatus().name(),
                List.of()
        );
    }

    public ProductReadResponse toDto(Product product, List<Tag> tags) {
        return new ProductReadResponse(
                product.getId(),
                product.getName(),
                product.getSlug(),
                product.getShortDescription(),
                product.getFullDescription(),
                product.getCreatedAt(),
                product.getUpdatedAt(),
                product.getSellerId(),
                product.getBrandId(),
                product.getStatus().name(),
                tagSummaryTranslator.toDtos(tags)
        );
    }
}
