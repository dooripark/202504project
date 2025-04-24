package com.example.ioc.domain;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    // 🔥 게시글은 EAGER 유지
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Post> posts = new ArrayList<>();

    // ❗ 주문은 Lazy로 바꾸고, 컨트롤러에서 size()로 강제 초기화
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();
}
