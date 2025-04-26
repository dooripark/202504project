// src/main/java/com/example/ioc/service/PostService.java
package com.example.ioc.service;

import com.example.ioc.domain.Post;
import com.example.ioc.domain.Reply;
import com.example.ioc.dto.PostDto;
import com.example.ioc.dto.ReplyDto; // ✨ 추가
import com.example.ioc.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors; // ✨ 추가

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post save(Post post) {
        return postRepository.save(post);
    }

    // ✨ 수정: Post 엔티티 → PostDto + 댓글도 ReplyDto로 변환
    public List<PostDto> findAll() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(post -> new PostDto(
                        post.getId(),
                        post.getTitle(),
                        post.getContent(),
                        post.getReplies().stream() // ✨ 추가: Post 안에 Reply 리스트를 ReplyDto로 변환
                                .map(reply -> new ReplyDto(reply.getId(), reply.getContent()))
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }
}
