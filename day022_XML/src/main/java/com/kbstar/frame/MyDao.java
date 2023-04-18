package com.kbstar.frame;

import java.util.List;

public interface MyDao<K, V> { // 기능정의하는 곳"따오"
    void insert(V v);
    public void delete(K k);
    public void update(V v);
    public V select(K k);
    public List<V> select();
    
}
