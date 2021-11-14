package com.arithmetic;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * author: Administrator
 * create: 2021-07-13 22:22
 * description: 运用你所掌握的数据结构，设计和实现一个 LFU (最近最不经常使用) 缓存机制
 * method: 需要使用一个HashMap存储key value 一个HashMap存储key frequency,
 *      一个LinkedHashSet存储相同frequency的key，一个变量保存当前最小的frequency
 */
public class LFUCache {
    HashMap<Integer, Integer> keyToVal;
    HashMap<Integer, Integer> keyToFreq;
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.capacity = capacity;
        minFreq = 0;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        // 增加key对应的次数
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            increaseFreq(key);
            return;
        }
        if (this.capacity <= keyToVal.size()) {
            removeMinFreq();
        }
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        minFreq = 1;
    }

    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        LinkedHashSet<Integer> keyList = freqToKeys.get(freq);
        keyList.remove(key);
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);
        if (keyList.isEmpty()) {
            freqToKeys.remove(freq);
            if (freq == this.minFreq) {
                this.minFreq += 1;
            }
        }
    }

    private void removeMinFreq() {
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        int removeKey = keyList.iterator().next();
        keyList.remove(removeKey);
        if (keyList.isEmpty()) {
            freqToKeys.remove(this.minFreq);
        }
        keyToVal.remove(removeKey);
        keyToFreq.remove(removeKey);
    }
}
