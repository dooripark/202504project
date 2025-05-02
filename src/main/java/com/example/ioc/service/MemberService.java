package com.example.ioc.service;

import com.example.ioc.domain.Member;
import com.example.ioc.domain.Order;
import com.example.ioc.domain.Post;
import com.example.ioc.domain.Reply;
import com.example.ioc.dto.MemberDto;
import com.example.ioc.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<MemberDto> findAll() {
        List<Member> members = memberRepository.findAll();
        return members.stream()
                .map(member -> new MemberDto(member.getId(), member.getUsername()))
                .collect(Collectors.toList());
    }

    public Member findById(Long id) {
        Member member = memberRepository.findById(id).orElse(null);

        if (member == null) {
            log.warn("❌ 해당 ID의 회원이 존재하지 않습니다.");
            return null;
        }

        log.info("🧾 회원: {}", member.getUsername());

        log.info("📌 게시글 수: {}", member.getPosts().size());
        for (Post post : member.getPosts()) {
            log.info("  - 게시글 제목: {}", post.getTitle());
            log.info("    댓글 수: {}", post.getReplies().size());
            for (Reply reply : post.getReplies()) {
                log.info("      · 댓글 내용: {}", reply.getContent());
            }
        }

        log.info("📦 주문 수: {}", member.getOrders().size());
        for (Order order : member.getOrders()) {
            log.info("  - 주문 아이템: {} (수량: {})", order.getItemName(), order.getQuantity());
        }

        return member;
    }

    @Transactional
    public void save(Member member) {
        memberRepository.save(member);
    }
}
