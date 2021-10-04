package com.arithmetic.dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * author: 19045752
 * create: 2021/5/28
 * description: 给你一个整数n，要求生成n对小括号的所有合法组合
 * method: 该题可以看作是使用小括号填充长度为2n的字符串，求该字符串合法的所有组合。那么可以用回溯算法，在当前位置放置(或者)后进行回溯，
 * 找出所有合法组合。使用两个变量分别记录(和)的使用次数，如果(的使用次数小于)括号，则当前路径不合法。
 * 当( )的都使用完毕后即找到一条合法路径
 */
public class GenerateParenthesis {
    List<String> res = new LinkedList<>();

    List<String> generateParenthesis(int n) {
        if (n == 0) {
            return res;
        }
        StringBuilder track = new StringBuilder();
        backtrack(n, n, track);
        return res;
    }

    void backtrack(int left, int right, StringBuilder track) {
        if (left > right) {
            return;
        }
        if (left < 0) {
            return;
        }
        if (right == 0) {
            res.add(track.toString());
            return;
        }

        track.append("(");
        backtrack(left - 1, right, track);
        track.deleteCharAt(track.length() - 1);

        track .append( ")");
        backtrack(left, right - 1, track);
        track.deleteCharAt(track.length() - 1);
    }
}
