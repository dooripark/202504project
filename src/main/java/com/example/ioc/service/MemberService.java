package com.example.ioc.service;

import com.example.ioc.domain.Member;
import com.example.ioc.domain.Order;
import com.example.ioc.domain.Post;
import com.example.ioc.domain.Reply;
import com.example.ioc.dto.MemberDto; // ✨ 추가: DTO import
import com.example.ioc.repository.MemberRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors; // ✨ 추가: stream 사용하려고 import

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // ✨ 수정: 엔티티 직접 반환 대신 DTO로 반환
    public List<MemberDto> findAll() {
        List<Member> members = memberRepository.findAll();
        return members.stream()
                .map(member -> new MemberDto(member.getId(), member.getUsername()))
                .collect(Collectors.toList());
    }

    // 그대로 유지 (ID로 조회하는 건 내부 확인용으로 남길게!)
    public Member findById(Long id) {
        Member member = memberRepository.findById(id).orElse(null);

        if (member == null) {
            System.out.println("❌ 해당 ID의 회원이 존재하지 않습니다.");
            return null;
        }

        System.out.println("🧾 회원: " + member.getUsername());

        System.out.println("📌 게시글 수: " + member.getPosts().size());
        for (Post post : member.getPosts()) {
            System.out.println("  - 게시글 제목: " + post.getTitle());
            System.out.println("    댓글 수: " + post.getReplies().size());
            for (Reply reply : post.getReplies()) {
                System.out.println("      · 댓글 내용: " + reply.getContent());
            }
        }

        System.out.println("📦 주문 수: " + member.getOrders().size());
        for (Order order : member.getOrders()) {
            System.out.println("  - 주문 아이템: " + order.getItemName() + " (수량: " + order.getQuantity() + ")");
        }

        return member;
    }

    @Transactional
    public void save(Member member) {
        memberRepository.save(member);
    }
}
