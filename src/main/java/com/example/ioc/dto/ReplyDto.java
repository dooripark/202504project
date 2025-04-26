package com.example.ioc.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyDto {

    private Long id;
    private String content;

    public ReplyDto(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}
