package com.wanted.ecommerce.tag.service;

import com.wanted.ecommerce.tag.domain.ProductTag;
import com.wanted.ecommerce.tag.repository.ProductTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductTagService {

    private final ProductTagRepository productTagRepository;

    public List<ProductTag> searchProductByTags(List<Long> tagIds) {
        return tagIds.stream().map(
                productTagRepository::findByTagId
        ).toList();
    }

    public List<ProductTag> getTagsByProduct(Long productId) {
        return productTagRepository.findByProductId(productId);
    }

    public void create(Long productId, Long tagId) {
        productTagRepository.save(new ProductTag(productId, tagId));
    }
}
