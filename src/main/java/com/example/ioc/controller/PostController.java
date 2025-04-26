package com.example.ioc.controller;

import com.example.ioc.domain.Post;
import com.example.ioc.dto.PostDto; // ✨ 추가: PostDto import
import com.example.ioc.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts_v2") // 경로를 변경해서 충돌 방지
public class PostController {

    @Autowired
    private PostService postService;

    // 등록 (그대로 사용) ➡️ 저장할 때는 Entity를 사용하니까 변경 없음
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(postService.save(post));
    }

    // 전체 조회
    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts() { // ✨ 수정: 반환 타입을 List<PostDto>로 변경
        return ResponseEntity.ok(postService.findAll()); // ✨ 수정: DTO로 변환된 리스트 반환
    }

    // 상세 조회 (그대로 사용) ➡️ 상세 조회할 때는 아직 엔티티로 조회
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        return postService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
