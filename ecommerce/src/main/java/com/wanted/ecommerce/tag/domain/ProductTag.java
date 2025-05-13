package com.wanted.ecommerce.tag.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString @Getter
@NoArgsConstructor
public class ProductTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "tag_id")
    private Long tagId;

    public ProductTag(Long productId, Long tagId) {
        this.productId = productId;
        this.tagId = tagId;
    }

}
