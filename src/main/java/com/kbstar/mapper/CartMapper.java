package com.kbstar.mapper;

import com.kbstar.dto.Cart;
import com.kbstar.frame.KBMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//얘는 스프링 컨테이너 위에서 돌릴거다.
//JDBC에서는 class로 만들어서 고생했지만, 매퍼로 만들것. 그러기 위해 interface
//interface는 interface를 상속(extend)임.
@Repository
@Mapper
public interface CartMapper extends KBMapper<Integer, Cart> {
    // 로그인한 회원이 담은 본인의 장바구니만 조회되도록 할 것이다.(기존 기능들 외 추가하기)
    public List<Cart> getmycart(String cid); // 의미 : 그러기 위해, DB에서 회원 id 가져오기(헷갈리니까 명칭 바꿈)

}
