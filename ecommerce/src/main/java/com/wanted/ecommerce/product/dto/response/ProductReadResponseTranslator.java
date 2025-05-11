package com.wanted.ecommerce.product.dto.response;

import com.wanted.ecommerce.common.translator.Translator;
import com.wanted.ecommerce.product.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductReadResponseTranslator implements Translator<Product, ProductReadResponse> {
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
                product.getStatus().name()
        );
    }
}
