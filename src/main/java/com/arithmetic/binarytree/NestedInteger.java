package com.arithmetic.binarytree;

import java.util.List;

/**
 * author: 19045752
 * create: 2021/5/2
 * description: 扁平化嵌套列表迭代器
 */
public class NestedInteger {
    private Integer val;
    private List<NestedInteger> list;

    public NestedInteger(Integer val) {
        this.val = val;
        this.list = null;
    }

    public NestedInteger(List<NestedInteger> list) {
        this.val = null;
        this.list = list;
    }

    public boolean isInteger() {
        return val != null;
    }

    public Integer getInteger() {
        return val;
    }

    public List<NestedInteger> getList() {
        return list;
    }
}
