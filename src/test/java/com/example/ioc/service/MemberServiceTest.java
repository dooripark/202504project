package com.example.ioc.service;

import com.example.ioc.domain.Member;
import com.example.ioc.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    void 회원_저장_테스트() {
        // given
        Member member = new Member();
        member.setUsername("dooripark");

        // when
        memberService.save(member);

        // then
        verify(memberRepository, times(1)).save(member); // save가 1번 호출됐는지 확인
    }
}
