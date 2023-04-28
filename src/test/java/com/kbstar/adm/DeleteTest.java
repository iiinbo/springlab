package com.kbstar.adm;

import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j // 로그 찍을거야
@SpringBootTest
class DeleteTest {
    @Autowired
    CustService service;
    @Test
    void contextLoads() {
    // cust 객체 만들어서 아규먼트 넣어본다.  테스트해보려고
        
        try {
            service.remove("id02");
        } catch (Exception e) { // 오류 예외처리(자동)
            //throw new RuntimeException(e);
                log.info("--------탈퇴 중 오류 발생");
           // e.printStackTrace(); // 에러 자세히
        }
    }

}
