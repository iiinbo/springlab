package com.kbstar.cust;

import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

@Slf4j // 로그 찍을거야
@SpringBootTest
class SelectOneTest {
    @Autowired
    CustService service;
    @Test
    void contextLoads() {
        Cust cust = null;
    // cust 객체 만들어서 아규먼트 넣어본다.  테스트해보려고 ok

        try {
            cust = service.get( "id01111" );
            log.info("----------------------");
            log.info(cust.toString());

        } catch (Exception e) { // 오류 예외처리(자동)
            //throw new RuntimeException(e);
                log.info("에러");
           // e.printStackTrace(); // 에러 자세히
        }
    }

}
