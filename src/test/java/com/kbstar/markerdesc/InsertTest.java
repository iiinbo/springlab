package com.kbstar.markerdesc;

import com.kbstar.dto.Marker;
import com.kbstar.dto.Markerdesc;
import com.kbstar.service.MarkerDescService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
/**
 * 4.28 정인보 insert 테스트 완료
 * 테스트 marker_id : 107 / 어향가지 추가 완료
 */
@Slf4j // 로그 찍을거야
@SpringBootTest
class InsertTest {
    @Autowired
    MarkerDescService service;
    @Test
    void contextLoads() {

        Markerdesc obj = new Markerdesc(0,106, "돼지국밥", 8000, "kuk1.jpg");
        try {
            service.register(obj);
            log.info("------- Markerdesc(맛집별 등록된 메뉴) 신규! 등록 완료 -------");
        } catch (Exception e) { // 오류 예외처리(자동)
            //throw new RuntimeException(e);
            if(e instanceof DuplicateKeyException){
                log.info("------- 등록실패 : 입력하신 id에 대한 Markerdesc(맛집별 등록된 메뉴) 정보에 동일한 id가 존재합니다. -------");
            }else{
                log.info("------- Markerdesc(맛집별 등록된 메뉴) 신규 등록에 실패했습니다.  -------");
            }
           // e.printStackTrace(); // 에러 자세히
        }
    }

}
