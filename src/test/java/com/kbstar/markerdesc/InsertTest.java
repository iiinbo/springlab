package com.kbstar.markerdesc;

import com.kbstar.dto.MarkerDesc;
import com.kbstar.service.MarkerdescService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

/**
 * 4.27 정인보 insert 테스트 완료
 * 테스트 id : 200 / 부잣집
 */
@Slf4j // 로그 찍을거야
@SpringBootTest
class InsertTest {
    @Autowired
    MarkerdescService service;
    @Test
    void contextLoads() {

        MarkerDesc obj = new MarkerDesc(0,108,"제삿상",1000000,"yang7");
        try {
            service.register(obj);
            log.info("------- 신규 메뉴 등록 완료!");
        } catch (Exception e) { // 오류 예외처리(자동)
            //throw new RuntimeException(e);
            if(e instanceof DuplicateKeyException){
                log.info("------- 등록실패 : Marker(맛집추천) 정보에 동일한 id가 존재합니다. -------");
            }else{
                log.info("------- Marker(맛집추천) 신규 등록에 실패했습니다.  -------");
            }
           // e.printStackTrace(); // 에러 자세히
        }
    }

}
