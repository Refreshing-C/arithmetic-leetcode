package com.arithmetic.unionquery;

/**
 * author: Administrator
 * create: 2021/6/27 0027
 * description: 图的并查集 将平面上的若干点相互连通，若a和b连通，b和c连通，则a和c也连通。
 * method: 将这些点构造成森林，用森林表示图的连通状态，用数组来实现这个森林，同时调整森林的高度不超过3
 */
public class UnionQuery {

    // parent数组实现森林，记录点之间的关系
    private final int[] parent;
    // 记录每个点下有多少个孩子节点
    private final int[] size;
    // 记录图的连通分量
    private int count;
    // n为图中点的个数
    public UnionQuery(int n) {
        this.count = n;
        this.parent = new int[n];
        this.size = new int[n];
        // 每个点的parent初始化为自己
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // 将p和q连通起来
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    // 判断p，q是否连通
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    // 返回当前连通分量
    public int count() {
        return count;
    }

    private int find(int curr) {
        while (parent[curr] != curr) {
            parent[curr] = parent[parent[curr]];
            curr = parent[curr];
        }
        return curr;
    }

}
