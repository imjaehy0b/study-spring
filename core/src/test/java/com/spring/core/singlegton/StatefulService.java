package com.spring.core.singlegton;

public class StatefulService {

   //private int price; //상태를 유지하는 필드

    public int order(String name, int price){
        System.out.println("name = " + name);
        System.out.println("price = " + price);
        System.out.println();
        return price;
    }

//    public int getPrice(){
//        return price;
//    }
}
