package com.example.ioc.controller;

import com.example.ioc.domain.Member;
import com.example.ioc.domain.Order;
import com.example.ioc.domain.Post;
import com.example.ioc.domain.Reply;
import com.example.ioc.repository.OrderRepository;
import com.example.ioc.repository.PostRepository;
import com.example.ioc.repository.ReplyRepository;
import com.example.ioc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private OrderRepository orderRepository;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // ✅ 1. 테스트 데이터 삽입용 API
    @GetMapping(value = "/test", produces = "text/plain; charset=UTF-8")
    public String insertTestData() {
        try {
            Member member = new Member();
            member.setUsername("dooripark");

            // 🔥 게시글 1
            Post post1 = new Post();
            post1.setTitle("첫 번째 게시글");
            post1.setContent("내용1");

            Reply reply1 = new Reply();
            reply1.setContent("첫 번째 댓글");
            reply1.setPost(post1); // 댓글 → 게시글 연결

            Reply reply2 = new Reply();
            reply2.setContent("두 번째 댓글");
            reply2.setPost(post1);

            post1.getReplies().add(reply1);
            post1.getReplies().add(reply2);
            post1.setMember(member); // 게시글 → 멤버 연결
            member.getPosts().add(post1); // 멤버 → 게시글 추가

            // 🔥 게시글 2 (댓글 없음)
            Post post2 = new Post();
            post2.setTitle("두 번째 게시글");
            post2.setContent("내용2");
            post2.setMember(member);
            member.getPosts().add(post2);

            // 🔥 주문 1
            Order order1 = new Order();
            order1.setItemName("액상 A");
            order1.setQuantity(2);
            order1.setMember(member);
            member.getOrders().add(order1);

            // 🔥 주문 2
            Order order2 = new Order();
            order2.setItemName("액상 B");
            order2.setQuantity(1);
            order2.setMember(member);
            member.getOrders().add(order2);

            // 🔥 최종 저장 (연관관계 모두 연결된 상태로 save)
            memberService.save(member);

            return "테스트 데이터 삽입 완료!";
        } catch (Exception e) {
            e.printStackTrace();
            return "에러 발생: " + e.getMessage();
        }
    }


    // ✅ 2. 전체 회원 조회
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.findAll();
    }

    // ✅ 3. 단일 회원 정보 상세 출력
    @Transactional
    @GetMapping("/{id}")
    public ResponseEntity<String> getMemberDetails(@PathVariable Long id) {
        Member member = memberService.findById(id);
        if (member == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("<pre>회원이 존재하지 않습니다.</pre>");
        }

        // 🔥 Lazy orders 강제 초기화
        member.getOrders().size();

        StringBuilder sb = new StringBuilder();
        sb.append("<pre>");
        sb.append("회원명: ").append(member.getUsername()).append("\n");

        sb.append("📌 게시글 수: ").append(member.getPosts().size()).append("\n");
        for (Post post : member.getPosts()) {
            sb.append(" - ").append(post.getTitle()).append("\n");
            sb.append("   댓글 수: ").append(post.getReplies().size()).append("\n");
            for (Reply reply : post.getReplies()) {
                sb.append("     · ").append(reply.getContent()).append("\n");
            }
        }

        sb.append("📦 주문 수: ").append(member.getOrders().size()).append("\n");
        for (Order order : member.getOrders()) {
            sb.append(" - ").append(order.getItemName())
                    .append(" (수량: ").append(order.getQuantity()).append(")\n");
        }

        sb.append("</pre>");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "text/html; charset=UTF-8");

        return new ResponseEntity<>(sb.toString(), headers, HttpStatus.OK);
    }
}
