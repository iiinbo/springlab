package com.kbstar.cart;

import com.kbstar.dto.Cart;
import com.kbstar.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class SelectTest {
    @Autowired
    CartService service;
    @Test
    void contextLoads() {

        try {
            service.get();
            log.info("--- cart(장바구니)에 담긴 item 전체 조회가 완료되었습니다. ---");
        } catch (Exception e) {
            log.info("시스템 장애입니다.==============================");
                e.printStackTrace();
            }
    }

}
