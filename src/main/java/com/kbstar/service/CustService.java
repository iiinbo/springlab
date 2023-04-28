package com.kbstar.service;

import com.kbstar.dto.Cust;
import com.kbstar.frame.KBService;
import com.kbstar.mapper.CustMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Slf4j // 로그 찍을거야
@Service
public class CustService implements KBService<String, Cust> {

    @Autowired // 주입
    CustMapper mapper; // Dao 가져다 사용하기(mapper) : 데이터를 보관하는 공간(DB)


    @Override
    public void register(Cust cust) throws Exception {
        mapper.insert(cust); // mapper : 데이터를 보관하는 공간(DB)

        log.info("-------Send Mail..." + cust.getId() ); // 로그찍기 : 정상 포함
    }

    @Override
    public void remove(String s) throws Exception {
        mapper.delete(s);
    }

    @Override
    public void modify(Cust cust) throws Exception {
        mapper.update(cust);
    }

    @Override
    public Cust get(String s) throws Exception {
        return  mapper.select(s);

    }

    @Override
    public List<Cust> get() throws Exception {
        return mapper.selectall();

    }
}
