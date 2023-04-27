package com.kbstar.adm;

import com.kbstar.dto.Adm;
import com.kbstar.service.AdmService;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j // 로그 찍을거야
@SpringBootTest
class SelectOneTest {
    @Autowired
    AdmService service;
    @Test
    void contextLoads() {

        try {
            service.get( "admin11" );

        } catch (Exception e) { // 오류 예외처리(자동)
            //throw new RuntimeException(e);
            log.info("어드민 이용자 조회 에러");
            // e.printStackTrace(); // 에러 자세히
        }
    }


}
