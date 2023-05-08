package com.kbstar.service;

import com.kbstar.dto.MarkerDesc;
import com.kbstar.frame.KBService;
import com.kbstar.mapper.MarkerDescMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkerdescService implements KBService<Integer, MarkerDesc> {

    @Autowired
    MarkerDescMapper mapper; // Marke의 DB와 연결된 dao 사용하겠다고 쓰기.

    @Override
    public void register(MarkerDesc markerdesc) throws Exception {
        mapper.insert(markerdesc);
    }

    @Override
    public void remove(Integer integer) throws Exception {
        mapper.delete(integer);
    }

    @Override
    public void modify(MarkerDesc markerdesc) throws Exception {
        mapper.update(markerdesc);
    }

    @Override
    public MarkerDesc get(Integer integer) throws Exception {
        return mapper.select(integer);
    }

    @Override
    public List<MarkerDesc> get() throws Exception {
        return mapper.selectall();
    }
    public List<MarkerDesc> getmarkerdesc(int id) throws Exception {
        return mapper.getmarkerdesc(id);
    }
}
