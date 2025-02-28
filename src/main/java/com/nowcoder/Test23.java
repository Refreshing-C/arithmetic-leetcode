package com.nowcoder;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 解题思路：如果二叉搜索树的左子树不空，则左子树的所有节点值都小于根节点，若右子树不空，则右子树的所有节点值都大于根节点
 *  后序遍历的最后一个元素为根，除去最后一个元素剩下的序列中前一部分均小于根节点，后一部分均大于根节点，且两部分都是合法的后序序列
 *
 */
public class Test23 {

    public boolean VerifySequenceOfBST(int[] sequence) {
        if (sequence.length == 0)
            return true;
        if (sequence.length == 1) {
            return false;
        }

        return adjustBST(sequence, 0, sequence.length - 1);
    }

    private boolean adjustBST(int[] a, int start, int end) {
        if (start >= end) {
            return true;
        }
        //从后面开始查找第一个比a[end]小的元素
        int i = end;
        while (i > start && a[i - 1] > a[end]) {
            i--;
        }

        //从i左边进行判断，如果存在比a[end]大的元素，则返回false
        for (int j = start; j < i; j++) {
            if (a[j] > a[end]) {
                return false;
            }
        }
        return adjustBST(a, start, i - 1) && adjustBST(a, i, end - 1);
    }
}
