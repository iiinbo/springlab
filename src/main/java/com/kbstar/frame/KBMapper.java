package com.kbstar.frame;

import java.util.List;

// 프레임 : 각 부서 존재하는 공간. 부서들이 해야할 일을 사무분담으로 지정해주는 공간
public interface KBMapper <K, V>{
        public void insert(V v) throws Exception;
        public void delete(K k) throws Exception;
        public void update(V v) throws Exception;
        public V select(K k) throws Exception;
        public List<V> selectall() throws Exception;
}
