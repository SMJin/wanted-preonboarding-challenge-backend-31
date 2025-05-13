package com.wanted.ecommerce.tag.repository;

import com.wanted.ecommerce.tag.domain.ProductTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductTagRepository extends JpaRepository<ProductTag, Integer> {

    ProductTag findByTagId(long tagId);

    List<ProductTag> findByProductId(long product);
}
