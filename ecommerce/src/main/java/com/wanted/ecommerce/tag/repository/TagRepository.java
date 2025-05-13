package com.wanted.ecommerce.tag.repository;

import com.wanted.ecommerce.tag.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Integer> {

    List<Tag> findByIdIn(List<Long> ids);
}
