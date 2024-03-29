package com.spring.core.discount;

import com.spring.core.annotation.MainDiscountPolicy;
import com.spring.core.member.Grade;
import com.spring.core.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountRateAmount = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            return price * discountRateAmount / 100;
        }else {
            return 0;
        }
    }
}
