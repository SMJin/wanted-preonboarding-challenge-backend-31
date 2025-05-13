package com.wanted.ecommerce.tag.service;

import com.wanted.ecommerce.tag.domain.Tag;
import com.wanted.ecommerce.tag.dto.request.TagRegisterRequest;
import com.wanted.ecommerce.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public List<Tag> getTagsByIds(List<Long> tagIds) {
        return tagRepository.findByIdIn(tagIds);
    }

    public void save(TagRegisterRequest request) {
        tagRepository.save(new Tag(request.getName(), request.getSlug()));
    }
}
