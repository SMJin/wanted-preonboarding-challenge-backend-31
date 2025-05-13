package com.wanted.ecommerce.tag.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class TagSummary {
    private Long tagId;
    private String tagName;
    private String tagSlug;
}
