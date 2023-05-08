package com.kbstar.markerdesc;

import com.kbstar.service.MarkerdescService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j // 로그 찍을거야
@SpringBootTest
class SelectDescTest {
    @Autowired
    MarkerdescService service;
    @Test
    void contextLoads() {

        try {
            service.getmarkerdesc( 108 ); // id : int
            log.info("-------입력하신 id에 대한 Marker(맛집추천) 정보 조회 성공! -------");
        } catch (Exception e) { // 오류 예외처리(자동)
            //throw new RuntimeException(e);
            log.info("-------  Marker(맛집추천) 조회 에러 발생 -------");
            // e.printStackTrace(); // 에러 자세히
        }
    }

}
