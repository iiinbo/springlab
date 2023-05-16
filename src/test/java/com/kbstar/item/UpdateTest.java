package com.kbstar.item;

import com.kbstar.dto.Item;
import com.kbstar.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
@Slf4j
public class UpdateTest {
    @Autowired
    ItemService service;
    @Test
    void contextLoads(){

        Item obj = new Item(105,"원숭이드레스",25000,"b.jpg",null);
        try {
            service.modify(obj);
            log.info("------- 입력한 id의 item 정보 수정 완료 ! -------");
        } catch (Exception e) {
            log.info("에러...");
            e.printStackTrace();
        }
    }
}
