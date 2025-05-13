package com.wanted.ecommerce.product.service;

import com.wanted.ecommerce.product.domain.Product;
import com.wanted.ecommerce.product.dto.request.ProductRegisterRequest;
import com.wanted.ecommerce.product.dto.response.ProductReadResponse;
import com.wanted.ecommerce.product.dto.response.ProductReadResponseTranslator;
import com.wanted.ecommerce.product.repository.ProductRepository;
import com.wanted.ecommerce.tag.domain.ProductTag;
import com.wanted.ecommerce.tag.domain.Tag;
import com.wanted.ecommerce.tag.service.ProductTagService;
import com.wanted.ecommerce.tag.service.TagService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final TagService tagService;
    private final ProductTagService productTagService;
    private final ProductReadResponseTranslator productReadResponseTranslator;

    @Transactional
    public Product create(ProductRegisterRequest request) {
        Product product = new Product(
                request.getName(),
                request.getSellerId(),
                request.getBrandId()
        );
        product.setSlug(request.getSlug());
        product.setShortDescription(request.getShortDescription());
        product.setFullDescription(request.getFullDescription());
        return productRepository.save(product);
    }

    @Transactional(readOnly = true)
    public ProductReadResponse read(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isEmpty()) return null;
        else {
            List<ProductTag> productTags = productTagService.getTagsByProduct(productId);
            List<Tag> tags = tagService.getTagsByIds(productTags.stream().map(ProductTag::getTagId).collect(Collectors.toList()));
            return productReadResponseTranslator.toDto(product.get(), tags);
        }
    }

    @Transactional(readOnly = true)
    public List<ProductReadResponse> readByIds(List<Long> productIds) {
        List<Product> products = productRepository.findByIdIn(productIds);
        return products.stream().map(
                product -> {
                    List<ProductTag> productTags = productTagService.getTagsByProduct(product.getId());
                    List<Tag> tags = tagService.getTagsByIds(productTags.stream().map(ProductTag::getTagId).collect(Collectors.toList()));
                    return productReadResponseTranslator.toDto(product, tags);
                }).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductReadResponse> readAll() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(
                product -> {
                    List<ProductTag> productTags = productTagService.getTagsByProduct(product.getId());
                    List<Tag> tags = tagService.getTagsByIds(productTags.stream().map(ProductTag::getTagId).collect(Collectors.toList()));
                    return productReadResponseTranslator.toDto(product, tags);
                }).collect(Collectors.toList());
    }

//    @Transactional(readOnly = true)
//    public List<ProductReadResponse> search(String columnName, String value) {
//        if (columnName.equ)
//
//        List<Product> productList = productRepository.();
//        return productList.stream().map(
//                productReadResponseTranslator::toDto
//        ).collect(Collectors.toList());
//    }
}
