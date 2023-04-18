package com.kbstar.frame;

import java.util.List; // alt + enter 자동 임포트

public interface MyDao<K, V> { // 기능정의하는 곳"따오"
    public void insert(V v);
    public void delete(K k);

    public V select(K k);
    
    public List<V> get();
    
}
