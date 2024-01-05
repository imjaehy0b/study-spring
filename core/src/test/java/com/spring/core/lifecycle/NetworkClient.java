package com.spring.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


public class NetworkClient{

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출 , url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //시작시 호출
    public void connect(){
        System.out.println("connect :  " + url);
    }

    public void call(String message){
        System.out.println("call : " +url+", message = "+message);
    }

    //종료시 호출
    public void disconnect(){
        System.out.println("close: "+ url);
    }

    @PostConstruct //의존관계주입이 끝나면 호출
    public void init() throws Exception {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지");
    }

    @PreDestroy // 빈이 종료될떄 호출
    public void close() throws Exception {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
