package com.kbstar.cart;

import com.kbstar.dto.Adm;
import com.kbstar.dto.Cart;
import com.kbstar.service.AdmService;
import com.kbstar.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
@Slf4j
class UpdateTest {
    @Autowired
    CartService service;
    @Test
    void contextLoads() {
        Cart obj = new Cart(105, "id01", 100, 777);
        try {
            service.modify(obj);
            log.info("장바구니 변경 완료");
            service.get(obj.getId());
        } catch (Exception e) {
                log.info("시스템 장애입니다.==============================");
                e.printStackTrace();
        }
    }

}
