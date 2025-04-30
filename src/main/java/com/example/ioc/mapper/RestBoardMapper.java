package com.example.ioc.mapper;

import com.example.ioc.dto.RestBoardDto;
import com.example.ioc.entity.RestBoard;

public class RestBoardMapper {

    public static RestBoardDto toDto(RestBoard entity) {
        return new RestBoardDto(entity.getId(), entity.getTitle(), entity.getContent());
    }

    public static RestBoard toEntity(RestBoardDto dto) {
        RestBoard entity = new RestBoard();
        entity.setId(dto.getId()); // 등록 시엔 null이여도 됨
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        return entity;
    }
}
