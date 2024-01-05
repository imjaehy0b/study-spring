package com.spring.core.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.spring.core.discount.FixDiscountPolicy;
import com.spring.core.member.Grade;
import com.spring.core.member.Member;
import com.spring.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

class OrderServiceImplTest {

    @Test
    void createOrder(){
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L,"name", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository,new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "item1", 10000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}