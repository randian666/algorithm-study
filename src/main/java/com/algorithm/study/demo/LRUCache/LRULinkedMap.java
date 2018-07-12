package com.algorithm.study.demo.LRUCache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap实现LRU缓存
 * @Author: liuxun
 * @CreateDate: 2018/7/12 下午8:42
 * @Version: 1.0
 */
public class LRULinkedMap<K,V> {
    /**
     * 最大缓存大小
     */
    private int cacheSize;
    private LinkedHashMap<K,V> cacheMap ;
    public LRULinkedMap(int cacheSize) {
        this.cacheSize = cacheSize;
        cacheMap = new LinkedHashMap(16,0.75F,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                if (cacheSize + 1 == cacheMap.size()){
                    return true ;
                }else {
                    return false ;
                }
            }
        };
    }
    public void put(K key,V value){
        cacheMap.put(key,value) ;
    }
    public V get(K key){
        return cacheMap.get(key) ;
    }
    public Collection<Map.Entry<K, V>> getAll() {
        return new ArrayList<Map.Entry<K, V>>(cacheMap.entrySet());
    }
    public static void main(String[] args) {
        LRULinkedMap<String,Integer> map = new LRULinkedMap(4) ;
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        map.put("4",4);
        map.put("5",5);
        for (Map.Entry<String, Integer> e : map.getAll()){
            System.out.print(e.getKey() + " : " + e.getValue() + "\t");
        }
    }
}
