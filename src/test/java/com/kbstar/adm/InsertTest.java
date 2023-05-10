package com.kbstar.adm;

import com.kbstar.dto.Adm;
import com.kbstar.service.AdmService;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

@Slf4j // 로그 찍을거야
@SpringBootTest
class InsertTest {
    @Autowired
    AdmService service;
    @Test
    void contextLoads() {
    // cust 객체 만들어서 아규먼트 넣어본다. register ok!
        Adm obj = new Adm("admin12", "pwd12", 2);
        //Adm obj = new Adm("admin13", "pwd13", 3);
        try {
            service.register(obj);
            log.info("어드민 관리자 권한 접속이용자 정상 등록");
        } catch (Exception e) { // 오류 예외처리(자동)
            //throw new RuntimeException(e);
            if(e instanceof DuplicateKeyException){
                log.info("--------신규 id가 중복되었습니다..");
            }else{
                log.info("정해지지 않은 시스템 장애입니다.");
            }
           // e.printStackTrace(); // 에러 자세히
        }
    }

}
