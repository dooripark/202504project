package com.example.ioc.service;

import com.example.ioc.domain.Member;
import com.example.ioc.domain.Order;
import com.example.ioc.domain.Post;
import com.example.ioc.domain.Reply;
import com.example.ioc.repository.MemberRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

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
