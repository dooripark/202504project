package com.example.ioc.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List; // ✨ 추가

@Getter
@Setter
public class PostDto {

    private Long id;
    private String title;
    private String content;
    private List<ReplyDto> replies; // ✨ 추가: 댓글 DTO 리스트

    public PostDto(Long id, String title, String content, List<ReplyDto> replies) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.replies = replies;
    }
}
