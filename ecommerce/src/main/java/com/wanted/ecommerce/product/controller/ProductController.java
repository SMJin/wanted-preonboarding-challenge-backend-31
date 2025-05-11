package com.wanted.ecommerce.product.controller;

import com.wanted.ecommerce.product.domain.Product;
import com.wanted.ecommerce.product.dto.request.ProductRegisterRequest;
import com.wanted.ecommerce.product.dto.response.ProductReadResponse;
import com.wanted.ecommerce.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public void create(@RequestBody ProductRegisterRequest request) {
        productService.create(request);
    }

    @GetMapping
    public List<ProductReadResponse> readAll() {
        return productService.readAll();
    }
}
