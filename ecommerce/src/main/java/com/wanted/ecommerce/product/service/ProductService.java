package com.wanted.ecommerce.product.service;

import com.wanted.ecommerce.product.domain.Product;
import com.wanted.ecommerce.product.dto.request.ProductRegisterRequest;
import com.wanted.ecommerce.product.dto.response.ProductReadResponse;
import com.wanted.ecommerce.product.dto.response.ProductReadResponseTranslator;
import com.wanted.ecommerce.product.repository.ProductRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductReadResponseTranslator productReadResponseTranslator;

    @Transactional
    public void create(ProductRegisterRequest request) {
        Product product = new Product(
                request.getName(),
                request.getSellerId(),
                request.getBrandId()
        );
        product.setSlug(request.getSlug());
        product.setShortDescription(request.getShortDescription());
        product.setFullDescription(request.getFullDescription());
        productRepository.save(product);
    }

    @Transactional(readOnly = true)
    public List<ProductReadResponse> readAll() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(
                productReadResponseTranslator::toDto
        ).collect(Collectors.toList());
    }
}
