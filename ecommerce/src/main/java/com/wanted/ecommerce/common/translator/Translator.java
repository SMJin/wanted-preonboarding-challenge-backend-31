package com.wanted.ecommerce.common.translator;

public interface Translator<ENTITY, DTO> {
    ENTITY toEntity(DTO dto);
    DTO toDto(ENTITY entity);
}
