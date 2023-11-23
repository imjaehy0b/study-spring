package com.spring.introduction.config;

import com.spring.introduction.aop.TimeTraceAop;
import com.spring.introduction.repository.JdbcMemberRepository;
import com.spring.introduction.repository.JdbcTemplateMemberRepository;
import com.spring.introduction.repository.JpaMemberRepository;
import com.spring.introduction.repository.MemberRepository;
import com.spring.introduction.repository.MemoryMemberRepository;
import com.spring.introduction.service.MemberService;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    private final EntityManager em;
    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
// return new MemoryMemberRepository();
// return new JdbcMemberRepository(dataSource);
// return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }

}
