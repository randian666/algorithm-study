package com.algorithm.study.demo.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap实现LRU缓存
 * @Author: liuxun
 * @CreateDate: 2018/7/12 下午8:42
 * @Version: 1.0
 */
public class LRULinkedMap<K,V> extends LinkedHashMap<K,V> {
    /**
     * 最大缓存大小
     */
    private int CACHESIZE;
    public LRULinkedMap(int cacheSize){
        // true 表示让 linkedHashMap 按照访问顺序来进行排序，最近访问的放在头部，最老访问的放在尾部。
        super(cacheSize,0.75f,true);
        CACHESIZE=cacheSize;
    }

    /**
     * 删除元素条件
     * @param eldest
     * @return
     */
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest){
        return size()>CACHESIZE;
    }
    public static void main(String[] args) {
        LRULinkedMap<String,Integer> map = new LRULinkedMap(4) ;
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        map.put("4",4);
        System.out.println(map.get("1"));
        map.put("5",5);
        for (Map.Entry<String, Integer> e : map.entrySet()){
            System.out.print(e.getKey() + " : " + e.getValue() + "\t");
        }
    }
}
