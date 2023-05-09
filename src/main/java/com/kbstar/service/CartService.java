package com.kbstar.service;

import com.kbstar.dto.Cart;
import com.kbstar.frame.KBService;
import com.kbstar.mapper.CartMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CartService implements KBService<Integer, Cart> {

    @Autowired
    CartMapper mapper;

    @Override
    public void register(Cart cart) throws Exception {
        mapper.insert(cart);
    }

    @Override
    public void remove(Integer s) throws Exception {
        mapper.delete(s);
    }

    @Override
    public void modify(Cart cart) throws Exception {
        mapper.update(cart);
    }

    @Override
    public Cart get(Integer s) throws Exception {
        return mapper.select(s);
    }

    @Override
    public List<Cart> get() throws Exception {
        return mapper.selectall();
    }

    // 본인의 장바구니만 조회하기(DB에선 cust 의 id(회원아이디.문자)를 가져오기 - cid라고 만들었다.)
    // 함수명은 맘대로 지었다. getmycart(모두 소문자)
    public List<Cart> getmycart(String cid) throws Exception {
        return mapper.getmycart(cid);
    }
}
