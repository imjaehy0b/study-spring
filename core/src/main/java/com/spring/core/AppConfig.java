package com.spring.core;

import com.spring.core.discount.DiscountPolicy;
import com.spring.core.discount.FixDiscountPolicy;
import com.spring.core.discount.RateDiscountPolicy;
import com.spring.core.member.MemberService;
import com.spring.core.member.MemberServiceImpl;
import com.spring.core.member.MemoryMemberRepository;
import com.spring.core.order.OrderService;
import com.spring.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(
                memberRepository()
        );
    }

    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
