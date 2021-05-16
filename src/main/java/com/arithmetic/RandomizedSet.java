package com.arithmetic;

import java.util.*;

/**
 * author: Administrator
 * create: 2021/5/15 0015
 * description: 设计一个支持在平均 时间复杂度 O(1) 下，执行插入 删除 等概率随机返回元素的数据结构。
 * method: 方案【哈希表+动态数组】HashMap支持常数级的插入和删除，但是无法获得随机值
 *     获得随机值本质上是产生一个随机索引，得到这个索引对应的值，列表有索引可以实现常数级的插入和获取随机值，
 *     但删除时需要重建索引，不过可以采用删除最后一个元素，将待删除元素和最后一个元素交换位置，需要使用HashMap来存储索引。
 */
public class RandomizedSet {
    /** Initialize your data structure here. */
    Map<Integer, Integer> indexMap;
    List<Integer> dataList;
    Random random = new Random();
    public RandomizedSet() {
        indexMap = new HashMap<>();
        dataList = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false;
        }
        // 插入时在列表末尾插入，先记录值和对应索引
        indexMap.put(val, dataList.size());
        dataList.add(dataList.size(), val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }
        // 拿到列表中最后一个元素
        int lastElement = dataList.get(dataList.size() - 1);
        // 待删除元素的索引
        int index = indexMap.get(val);
        // 交换待删除元素和最后一个元素
        dataList.set(index, lastElement);
        // 更新索引
        indexMap.put(lastElement, index);
        dataList.remove(dataList.size() - 1);
        indexMap.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return dataList.get(random.nextInt(dataList.size()));
    }
}
