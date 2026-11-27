package com.rv.infosys;

import java.util.*;

public class LRUCache {
    private final int capacity;
    private Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    public void add(Integer key, Integer value) {
        if (map.size() >= capacity) {
            remove();
        }
        map.put(key, value);
        List.of(1, 2, 3);
    }

    private void remove() {
        Iterator<Integer> iterator = map.keySet().iterator();
        Integer firstKey = iterator.next();
        map.remove(firstKey);
    }

    public void getAll() {
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
    }
}
