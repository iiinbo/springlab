package com.kbstar.cust;

import com.github.pagehelper.PageInfo;
import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CustPageTest {
    @Autowired
    CustService service;

    @Test
    void contextLoads(){
        PageInfo<Cust> pageInfo;

        try {
            pageInfo = new PageInfo<>(service.getpage(2), 5 ); // 몇번 째 페이지 가져올까?
            log.info("------- 전체조회 정상완료 -------");
        } catch (Exception e) {
            log.info("에러...");
            e.printStackTrace();
        }
    }
}
