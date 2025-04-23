package com.example.ioc;

import com.example.ioc.TestAppConfig;
import com.example.ioc.domain.Member;
import com.example.ioc.domain.Post;
import com.example.ioc.repository.MemberRepository;
import com.example.ioc.repository.PostRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestApp {
    public static void main(String[] args) {
        // AppConfig는 너의 @Configuration 클래스
        ApplicationContext context = new AnnotationConfigApplicationContext(TestAppConfig.class);

        MemberRepository memberRepo = context.getBean(MemberRepository.class);
        PostRepository postRepo = context.getBean(PostRepository.class);

        // ✅ 1. 회원 생성
        Member member = new Member();
        member.setUsername("dooripark");
        memberRepo.save(member);

        // ✅ 2. 게시글 생성 후 회원 연관 설정
        Post post1 = new Post();
        post1.setTitle("첫 번째 게시글");
        post1.setContent("내용입니다!");
        post1.setMember(member); // 연관관계 설정

        Post post2 = new Post();
        post2.setTitle("두 번째 게시글");
        post2.setContent("또 다른 내용입니다!");
        post2.setMember(member); // 연관관계 설정

        postRepo.save(post1);
        postRepo.save(post2);

        // ✅ 3. 회원 다시 조회해서 게시글 확인
        Member foundMember = memberRepo.findById(member.getId()).orElse(null);
        System.out.println("회원명: " + foundMember.getUsername());
        System.out.println("게시글 수: " + foundMember.getPosts().size());
        for (Post p : foundMember.getPosts()) {
            System.out.println("  - " + p.getTitle());
        }
    }
}
