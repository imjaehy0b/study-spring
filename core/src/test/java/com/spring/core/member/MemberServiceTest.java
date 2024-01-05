package com.spring.core.member;

import static org.assertj.core.api.Assertions.assertThat;

import com.spring.core.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach // 테스트 실행전 실행됨
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        // Given
        Member member = new Member(1L,"memberA",Grade.VIP);

        // When
        memberService.join(member); //가입
        Member findeMember = memberService.findMember(1L); //조회

        // Then
        assertThat(member).isEqualTo(findeMember);
    }
}
