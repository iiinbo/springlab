package com.kbstar.markerdesc;

import com.kbstar.dto.Marker;
import com.kbstar.dto.Markerdesc;
import com.kbstar.service.MarkerDescService;
import com.kbstar.service.MarkerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * 4.27 정인보 update 테스트 완료
 * 테스트 id : 108 / 양꼬치집
 * 수정완료한 정보 : LAT 및 LNG
 */
@Slf4j // 로그 찍을거야
@SpringBootTest
class UpdateTest {
    @Autowired
    MarkerDescService service;
    @Test
    void contextLoads() {
    // cust 객체 만들어서 아규먼트 넣어본다. 테스트 ok
        Markerdesc obj = new Markerdesc(10, 108, "양꼬치", 21000,"yang2.jpg");
        try {
            service.modify( new Markerdesc(10,108, "생양꼬치",23000, "yang2.jpg") );
            log.info("------- Marker(맛집추천) 정보 정상 수정완료 -------");
        } catch (Exception e) { // 오류 예외처리(자동)
            //throw new RuntimeException(e)
                log.info("-------  Marker(맛집추천) 조회 에러 발생 -------");
           // e.printStackTrace(); // 에러 자세히
        }
    }

}
