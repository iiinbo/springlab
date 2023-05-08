package com.kbstar.frame;

import com.kbstar.dto.Cart;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface KBService<K,V> {

    @Transactional   /* 트랜잭션 오류 발생시 롤백을 시켜줌 */

    public void register(V v) throws Exception;
    public void remove(K k) throws Exception;
    public void modify(V v) throws Exception;
    public V get(K k) throws Exception;

    public List<V> get() throws Exception;

}
