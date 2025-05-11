package com.wanted.ecommerce.product.service;

import com.wanted.ecommerce.product.domain.Product;
import com.wanted.ecommerce.product.dto.request.ProductRegisterRequest;
import com.wanted.ecommerce.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

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
}
