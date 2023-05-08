package com.kbstar.cust;

import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

@Slf4j
@SpringBootTest
class InsertTest {

    @Autowired
    CustService service;
    @Test
    void contextLoads() {
        Cust obj = new Cust("id09","pwd03","심말숙");
        try {
            service.register(obj);
            log.info("등록이 되었다");
            service.get();
        } catch (Exception e) {
            log.info("등록 에러......");
            e.printStackTrace();
            if (e instanceof DuplicateKeyException) {
                log.info("ID가 중복되었습니다------------------------------------------------");
            }else{
                log.info("시스템장애입니다. 관리자에게 문의바랍니다------------------------------");
            }
        }
    }
}
