package com.kbstar.mapper;

import com.kbstar.dto.Cart;
import com.kbstar.dto.Marker;
import com.kbstar.frame.KBMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//  스프링컨테이너 덕분이다~
@Repository
@Mapper
public interface MarkerMapper extends KBMapper<Integer, Marker> {

    // 특정지역 담은 본인의 맛집만 조회되도록 할 것이다.(기존 기능들 외 추가하기)
    public List<Marker> getmybob(String loc); // db에서 loc 스트링 가져오기.
}
