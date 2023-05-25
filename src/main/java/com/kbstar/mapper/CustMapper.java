package com.kbstar.mapper;

import com.github.pagehelper.Page;
import com.kbstar.dto.Cust;
import com.kbstar.dto.Item;
import com.kbstar.frame.KBMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

// mapper(DAO) : 데이터를 보관하는 공간.
 // 인터페이스에서 인터페이스로 상속받을 땐, 임플리먼츠 x

    // 예전처럼, DTO(팀원)이 어느부서에서 무슨일을 하는지 아래에 작성하지 않아도
    // @ 두개 작성해주면 DAO 완성.
    //  스프링컨테이너 덕분이다~
@Repository
@Mapper
public interface CustMapper extends KBMapper<String, Cust> {
        // 페이징 처리를 위한 함수 만들기. list가 아니라, Page라는 곳에 Cust 담는다.
        Page<Cust> getpage() throws Exception;
}
