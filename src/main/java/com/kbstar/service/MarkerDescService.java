package com.kbstar.service;

import com.kbstar.dto.Markerdesc;
import com.kbstar.frame.KBService;
import com.kbstar.mapper.MarkerDescMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkerDescService implements KBService<Integer, Markerdesc> {

    @Autowired
    MarkerDescMapper mapper; // Markerdesc의 DB와 연결된 dao 사용하겠다고 쓰기.

    /**
     * 등록 & 가입 진행
     * argument : object
     * return : null
     *
     * @param markerdesc
     **/
    @Override
    public void register(Markerdesc markerdesc) throws Exception {
        mapper.insert(markerdesc);
    }

    @Override
    public void remove(Integer integer) throws Exception {
        mapper.delete(integer);
    }

    @Override
    public void modify(Markerdesc markerdesc) throws Exception {
        mapper.update(markerdesc);
    }


    @Override
    public Markerdesc get(Integer integer) throws Exception {
        return mapper.select(integer);
    }

    @Override
    public List<Markerdesc> get() throws Exception {
        return mapper.selectall();
    }

    //
    public List<Markerdesc> getmarkerdesc(int mid) throws Exception {
        return mapper.getmarkerdesc( mid );
    }

}
