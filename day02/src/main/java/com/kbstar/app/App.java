package com.kbstar.app;

import com.kbstar.frame.TV;
import com.kbstar.tv.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String args[]){
       // spring 컨테이너를 이용해 역제어로, 객체(ltv, stv) 가져와보기
        ApplicationContext factory =
                new ClassPathXmlApplicationContext("spring.xml");
        // 역제어 표현방법 익히기 : IoC
        TV tv = (TV)factory.getBean("stv"); // stv 검색해서(lookup) tv로 주입시켜(injection)
        tv.turnOn(); // 삼성티비 키기.
        
    }
}
