package com.spring.core;

import com.spring.core.member.Grade;
import com.spring.core.member.Member;
import com.spring.core.member.MemberService;
import com.spring.core.member.MemberServiceImpl;
import com.spring.core.order.Order;
import com.spring.core.order.OrderService;
import com.spring.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member memberA = new Member(memberId, "MemberA", Grade.VIP);
        memberService.join(memberA);

        Long memberId2 = 2L;
        Member memberB = new Member(memberId2, "MemberB", Grade.BASIC);
        memberService.join(memberB);
        //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());

        System.out.println("======================");

        Order order2 = orderService.createOrder(memberId2, "itemB", 10000);
        System.out.println("order2 = " + order2);
        System.out.println("order2.calculatePrice() = " + order2.calculatePrice());

    }
}
