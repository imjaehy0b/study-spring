package com.spring.core.order;

import com.spring.core.annotation.MainDiscountPolicy;
import com.spring.core.discount.DiscountPolicy;
import com.spring.core.member.Member;
import com.spring.core.member.MemberRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor // final 이 붙은 필드를 가지고 생성자를 만들어준다.
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    @RequiredArgsConstructor 를통해 자동으로 생성됨
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountedPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName,itemPrice,discountedPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
