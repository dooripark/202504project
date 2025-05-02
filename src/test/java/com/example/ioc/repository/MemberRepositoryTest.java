package com.example.ioc.repository;

import com.example.ioc.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("username으로 회원 조회 테스트")
    void testFindByUsername() {
        // username이 중복되지 않게 먼저 삭제하고 시작
        memberRepository.deleteAll();

        // 테스트 데이터 저장
        Member member = new Member();
        member.setUsername("dooripark");
        memberRepository.save(member);

        // 조회
        Optional<Member> result = memberRepository.findByUsername("dooripark");

        // 검증
        assertThat(result).isPresent();
        assertThat(result.get().getUsername()).isEqualTo("dooripark");
    }
}
