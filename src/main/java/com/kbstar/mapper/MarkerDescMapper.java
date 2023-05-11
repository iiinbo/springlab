package com.kbstar.mapper;


import com.kbstar.dto.Marker;
import com.kbstar.dto.Markerdesc;
import com.kbstar.frame.KBMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


//  스프링컨테이너 덕분이다~
@Repository
@Mapper
public interface MarkerDescMapper extends KBMapper<Integer, Markerdesc> {

    // (기존 기능들 외 추가하기)
    public List<Markerdesc> getmarkerdesc(int mid); // db에서 marker_id 스트링 가져오기.
}
