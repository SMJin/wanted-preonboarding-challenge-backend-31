package com.wanted.ecommerce.tag.dto;

import com.wanted.ecommerce.common.translator.Translator;
import com.wanted.ecommerce.tag.domain.Tag;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TagSummaryTranslator implements Translator<Tag, TagSummary> {
    @Override
    public Tag toEntity(TagSummary tagSummary) {
        return new Tag(
                tagSummary.getTagId(),
                tagSummary.getTagName(),
                tagSummary.getTagSlug()
        );
    }

    public List<Tag> toEntities(List<TagSummary> tagSummaries) {
        return tagSummaries.stream().map(
                this::toEntity).collect(Collectors.toList());
    }

    @Override
    public TagSummary toDto(Tag tag) {
        return new TagSummary(
                tag.getId(),
                tag.getName(),
                tag.getSlug()
        );
    }
    public List<TagSummary> toDtos(List<Tag> tags) {
        return tags.stream().map(
                this::toDto).collect(Collectors.toList());
    }
}
