package com.arithmetic.binarytree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * author: 19045752
 * create: 2021/5/2
 * description:
 */
public class NestedIterator implements Iterator<Integer> {
    private final LinkedList<NestedInteger> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new LinkedList<>(nestedList);
    }

    @Override
    public boolean hasNext() {
        // 循环拆分列表，直到列表的第一个元素是整数
        while (!list.isEmpty() && !list.get(0).isInteger()) {
            // 当列表开头元素是列表类型时，将该列表打平并添加到列表开头
            List<NestedInteger> first = list.remove(0).getList();
            for (int i = first.size() - 1; i > 0; i--) {
                list.addFirst(first.get(i));
            }
        }
        return !list.isEmpty();
    }

    @Override
    public Integer next() {
        // 每次调用next方法时，返回的是一个整数
        return list.remove(0).getInteger();
    }
}
