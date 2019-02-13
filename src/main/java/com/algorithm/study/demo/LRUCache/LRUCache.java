package com.algorithm.study.demo.LRUCache;

import java.util.*;

/**
 * LinkedHashMap实现LRU缓存
 * @Author: liuxun
 * @CreateDate: 2019/2/13 上午10:24
 * @Version: 1.0
 */
public class LRUCache {
    MapCache cache;
    public LRUCache(int capacity) {
        this.cache = new MapCache(capacity);
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
    public Collection<Map.Entry<Integer, Integer>> getAll() {
        return new ArrayList<Map.Entry<Integer, Integer>>(cache.entrySet());
    }
    class MapCache extends LinkedHashMap<Integer, Integer> {
        public int max;
        public MapCache(int max) {
            super(max, 0.75f, true);
            this.max = max;
        }
        protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
            return size() > max;
        }

    }
    public static void main(String[] args) {
        LRUCache map = new LRUCache(2) ;
        map.put(1,1);
        System.out.println(map.get(4));
        for (Map.Entry<Integer, Integer> e : map.getAll()){
            System.out.print(e.getKey() + " : " + e.getValue() + "\t");
        }
    }
}


