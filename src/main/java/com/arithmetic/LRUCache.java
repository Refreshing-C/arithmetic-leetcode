package com.arithmetic;

import java.util.LinkedHashMap;

/**
 * author: Administrator
 * create: 2021-07-11 22:50
 * description: 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制
 * method: 要在O(1)时间复杂度内完成get和put，那么要使用到LinkedHashMap这种数据结构
 */
public class LRUCache {
    int capacity;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecently(key);
            return;
        }
        if (cache.size() >= this.capacity) {
            // 链表头部就是最久未使用的key
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        cache.put(key, value);
    }

    /**
     * 将key变成最近使用的
     *
     * @param key
     */
    private void makeRecently(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}
