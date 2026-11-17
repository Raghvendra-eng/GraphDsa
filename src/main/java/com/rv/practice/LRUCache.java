package com.rv.practice;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private final int capacity;
    private final Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) return map.get(key);
        return -1;
    }

    public void put(int key, int value) {
        if (map.size() >= capacity) {
            Integer first = map.keySet().iterator().next();
            map.remove(first);
        }
        map.put(key, value);
    }

}
