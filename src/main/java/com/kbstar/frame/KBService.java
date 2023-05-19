package com.kbstar.frame;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
// 프레임 : 각 부서 존재하는 공간. 부서들이 해야할 일을 사무분담으로 지정해주는 공간

public interface KBService<K, V> {
    /**
     * 등록 & 가입 진행
     * argument : object
     * return : null
     * **/
    @Transactional // mapper에 여러번 데이터가 입력될 때, 어느 한 곳이라도 실패하면~ 전체 Rollback해준다.
    // 가장 상위클래스에 선언해주면 하위 다 적용~
    public void register (V v) throws Exception;
    @Transactional
    public void remove (K k) throws Exception;
    @Transactional
    public void modify (V v) throws Exception;
    @Transactional(readOnly = true)
    public V get (K k) throws Exception;
    @Transactional(readOnly = true)
    public List<V> get () throws Exception;
}
