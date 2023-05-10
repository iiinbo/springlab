package com.kbstar.markerdesc;

import com.kbstar.service.MarkerDescService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * 4.28 정인보 delete 테스트 완료
 * 테스트 marker_id : 107 / 3건 전체 삭제 완료
 */
@Slf4j // 로그 찍을거야
@SpringBootTest
class DeleteTest {
    @Autowired
    MarkerDescService service;
    @Test
    void contextLoads() {

        try {
            service.remove(107);
            log.info("------- Markerdesc(맛집별 등록된 메뉴)  정보 전체삭제 성공! -------");
        } catch (Exception e) { // 오류 예외처리(자동)
            //throw new RuntimeException(e);
                log.info("-------Markerdesc(맛집별 등록된 메뉴) 삭제 실패! 오류 발생 -------");
           // e.printStackTrace(); // 에러 자세히
        }
    }

}
