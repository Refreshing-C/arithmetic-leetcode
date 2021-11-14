package com.arithmetic;

import java.util.HashMap;
import java.util.Stack;

/**
 * author: Administrator
 * create: 2021-11-14 22:24
 * description: 最大频率栈
 * method: 需要有一个变量记录最大频率，一个HashMap记录key对应的频率，一个HashMap记录频率对应的key
 */
public class FreqStack {
    int maxFreq = 0;
    HashMap<Integer, Integer> keyToVal;
    HashMap<Integer, Stack<Integer>> freqToKey;

    public FreqStack() {
        keyToVal = new HashMap<>();
        freqToKey = new HashMap<>();
    }

    public void push(int val) {
        int freq = keyToVal.getOrDefault(val, 0);
        keyToVal.put(val, freq + 1);
        freqToKey.putIfAbsent(freq, new Stack<>());
        freqToKey.get(freq).push(val);
        maxFreq = Math.max(maxFreq, freq);
    }

    public int pop() {
        Stack<Integer> vals = freqToKey.get(maxFreq);
        int v = vals.pop();
        int freq = keyToVal.get(v) - 1;
        keyToVal.put(v, freq);
        if (vals.isEmpty()) {
            maxFreq -= 1;
        }
        return v;
    }
}
