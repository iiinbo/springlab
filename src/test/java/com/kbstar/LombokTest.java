package com.kbstar;

import com.kbstar.dto.CustDTO;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LombokTest {
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    @Test
    void contextLoads() {
        CustDTO cust = new CustDTO("id01", "pwd01", "newjeans");
        logger.info(cust.toString());
        // 이 출력방식은 이제 사용 안해! System.out.println(cust.toString()); //
    }

}
