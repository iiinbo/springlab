package com.kbstar.cart;

import com.kbstar.dto.Cart;
import com.kbstar.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.util.Date;
/**
 * 4.27 정인보 insert 테스트 완료
 *
 * ㅇ 테스트 시 사용한 cust_id : id20
 * 테스트 1 : cust 테이블에 cust_id 존재 & item 테이블에 item_id 존재 시만 insert 완료
 * 테스트 2 : cust 테이블에 cust_id  || item 테이블에 item_id 중 1개라도 미존재 => 실패
 * 테스트 3 : cnt - 수량 : 0 이상 ~ item 테이블에 존재하는 만큼의 수량만 수정/입력될 것
 *
 */
@SpringBootTest
@Slf4j
class InsertTest {
    @Autowired
    CartService service;
    @Test
    void contextLoads() {
        Cart obj = new Cart(0, "id03", 101, 3);
        // id자동생성되게 컨스트럭터 만들었다면 아래처럼
        //Cart obj = new Cart( "id20", 103, 20, null);
        try {
            service.register(obj);
            log.info("--- cart(장바구니)에 item을 성공적으로 담았습니다. ---");
        } catch (Exception e) {
            if(e instanceof DuplicateKeyException){
                log.info("아이디가 중복되었습니다===========================");
            }else {
                log.info("시스템 장애입니다.==============================");
                e.printStackTrace();
            }
        }
    }

}
