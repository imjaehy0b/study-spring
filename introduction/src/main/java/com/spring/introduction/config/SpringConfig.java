package com.spring.introduction.config;

import com.spring.introduction.repository.MemberRepository;
import com.spring.introduction.repository.MemoryMemberRepository;
import com.spring.introduction.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
