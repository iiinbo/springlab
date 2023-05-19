package com.kbstar.item;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.kbstar.dto.Item;
import com.kbstar.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class SelectPageTest {
    @Autowired
    ItemService service;

    @Test
    void contextLoads(){
        PageInfo<Item> pageInfo;

        try {
            pageInfo = new PageInfo<>(service.getpage(3), 5 ); // 몇번 째 페이지 가져올까?
            log.info("------- 전체조회 정상완료 -------");
        } catch (Exception e) {
            log.info("에러...");
            e.printStackTrace();
        }
    }
}
