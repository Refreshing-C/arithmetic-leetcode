package com.arithmetic.unionquery;

/**
 * author: Administrator
 * create: 2021/6/27 0027
 * description: 一个数组装着若干由字符串组成的算式，这些算式长度都为4，算式的关系只有==或!=，
 *          若数组中所有算式都成立则返回true，否则返回false
 * method: 把这些式子拆掉，相等的用并查集连接起来，遇到不等式时，判断是否被连接
 */
public class EquationPossible {
    public boolean equationPossible(String[]equations) {
        UnionQuery uq = new UnionQuery(26);
        // 先让相等的字母形成连通分量
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int p = eq.charAt(0) - 'a';
                int q = eq.charAt(3) - 'a';
                uq.union(p , q);
            }
        }
        // 检查不等关系是否打破了相等关系的连通性
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int p = eq.charAt(0) - 'a';
                int q = eq.charAt(3) - 'a';
                if(uq.connected(p, q)) {
                    return false;
                }
            }
        }
        return true;
    }
}
