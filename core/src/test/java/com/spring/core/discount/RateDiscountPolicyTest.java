package com.spring.core.discount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.spring.core.member.Grade;
import com.spring.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("vip는 10% 할인")
    void vip_o(){
        // Given
        Member member = new Member(1L,"VIP_member",Grade.VIP);
        // When
        int discount = rateDiscountPolicy.discount(member,10000);
        // Then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("vip가 아니라면 할인 불가")
    void vip_x(){
        // Given
        Member member = new Member(1L,"Basic_member",Grade.BASIC);
        // When
        int discount = rateDiscountPolicy.discount(member,10000);
        // Then
        assertThat(discount).isEqualTo(0);
    }
//    @Test
//    void discount() {
//        Long memberId = 1L;
//        Member member = new Member(memberId,"memeberA", Grade.VIP);
//
//        int result = rateDiscountPolicy.discount(member,13900);
//        System.out.println(result);
//    }
}