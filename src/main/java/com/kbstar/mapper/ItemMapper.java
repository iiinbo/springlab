package com.kbstar.mapper;


import com.github.pagehelper.Page;
import com.kbstar.dto.Cust;
import com.kbstar.dto.Item;
import com.kbstar.frame.KBMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ItemMapper extends KBMapper<Integer, Item> {

    // 페이징 처리를 위한 함수 만들기. list가 아니라, Page라는 곳에 item을 담는다.
    Page<Item> getpage() throws Exception;

}