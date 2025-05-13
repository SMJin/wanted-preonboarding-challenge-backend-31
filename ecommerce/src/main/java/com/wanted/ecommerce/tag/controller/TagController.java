package com.wanted.ecommerce.tag.controller;

import com.wanted.ecommerce.tag.dto.request.TagRegisterRequest;
import com.wanted.ecommerce.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @PostMapping
    public void create(@RequestBody TagRegisterRequest request) {
        tagService.save(request);
    }
}
