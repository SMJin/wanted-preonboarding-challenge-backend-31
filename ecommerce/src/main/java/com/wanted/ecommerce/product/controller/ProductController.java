package com.wanted.ecommerce.product.controller;

import com.wanted.ecommerce.product.domain.Product;
import com.wanted.ecommerce.product.dto.request.ProductRegisterRequest;
import com.wanted.ecommerce.product.dto.request.ProductSearchRequest;
import com.wanted.ecommerce.product.dto.response.ProductReadResponse;
import com.wanted.ecommerce.product.service.ProductService;
import com.wanted.ecommerce.tag.domain.ProductTag;
import com.wanted.ecommerce.tag.service.ProductTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductTagService productTagService;

    @PostMapping
    public void create(@RequestBody ProductRegisterRequest request) {
        Product product = productService.create(request);
        if (request.getTagIds() != null && !request.getTagIds().isEmpty()) {
            for (Long tagId : request.getTagIds()) {
                productTagService.create(product.getId(), tagId);
            }
        }
    }

    @GetMapping
    public List<ProductReadResponse> readAll() {
        return productService.readAll();
    }

    @GetMapping("/{productId}")
    public ProductReadResponse read(@PathVariable Long productId) {
        return productService.read(productId);
    }

    @GetMapping("/search")
    public List<ProductReadResponse> search(@RequestParam ProductSearchRequest request) {
        List<ProductReadResponse> results = new ArrayList<>();

        if (request.getTagIds() != null && !request.getTagIds().isEmpty()){
            List<ProductTag> productTags = productTagService.searchProductByTags(request.getTagIds());
            List<Long> productIds = productTags.stream().map(
                    ProductTag::getProductId
            ).toList();
            results.addAll(productService.readByIds(productIds));
        }

        return results;
    }
}
