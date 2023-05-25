package com.kbstar.item;

import com.kbstar.dto.Item;
import com.kbstar.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.util.Date;

@SpringBootTest
@Slf4j
public class InsertTest {
    @Autowired
    ItemService service;
    @Test
    void contextLoads(){
        // id가 시퀀스 적용되면 0으로 넣는다. Date도 쓴다면 null이라고 넣는다.
        Item obj = new Item(0, "원숭이바지",20000,"b.jpg",null);
        try {
            service.register(obj);
            log.info("------- item 상품등록 완료! -------");
        } catch (Exception e) {
            if( e instanceof DuplicateKeyException) {
                log.info("ID가 중복 되었습니다.-----------------------------------------------------");
            }else {
                log.info("시스템 장애입니다.-----------------------------------------------------");
            }
        }
    }
}
