package com.kbstar.app;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserInsertTest {
    public static void main(String[] args) {
        ApplicationContext factory =
                new ClassPathXmlApplicationContext("spring.xml");

        MyService<String, UserDTO> service = // 주입
                (MyService<String, UserDTO>) factory.getBean("uservice");

        UserDTO u = new UserDTO("id01", "pwd01", "lee"); // 검색
        service.register(u);
    }
}