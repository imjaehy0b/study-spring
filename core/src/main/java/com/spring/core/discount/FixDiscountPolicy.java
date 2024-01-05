package com.spring.core.discount;

import com.spring.core.member.Grade;
import com.spring.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; //고정 천원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade()== Grade.VIP){
            return discountFixAmount;
        }
        return 0;
    }
}
