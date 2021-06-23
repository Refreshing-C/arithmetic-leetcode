package com.arithmetic.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * author: Administrator
 * create: 2021/6/20 0020
 * description: 盗贼计划打劫街的房屋，但是不能在同一晚上闯入相邻的两间屋子，
 *          给定一个代表每个房屋存放金额的非负整数数组，求能偷窃到的最高金额
 * method: 状态是每间房屋，选择是抢或不抢，抢的话去下下一间，不抢去下一间。
 */
public class HouseRobber {
    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[0];
    }

    /**
     * 街的房屋组成了一个环，第一家和最后一家也不能同时进入 问能偷窃的最大金额
     * 有3种可能，第一家最后一家都不进，进第一家不进最后一家，进最后一家不进第一家。
     * 明显进入一家要比都不进拿到的多，可以分别计算第二种和第三种最后求最大金额
     *
     * @param nums
     * @return
     */
    public int robWithRoll(int[] nums) {
        int n = nums.length;
        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
    }

    private int robRange(int[] nums, int start, int end) {
        int dp_i_1 = 0;
        int dp_i_2 = 0;
        int dp_i = 0;
        for (int i = end; i >= start; i--) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }

    /**
     * 街上的房屋组成了一棵二叉树，房子在二叉树的节点上，相连的两个房子不能同时被抢窃。
     * 抢了根节点，就只能抢根节点的孩子节点的孩子节点，若不抢根节点，就抢两个孩子节点的房屋
     * @param nums
     * @return
     */
    Map<TreeNode, Integer> memo = new HashMap<>();
    public int robWithBT(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        // 抢 然后去下下家
        int doIt = root.val
                + (root.left == null ? 0 : robWithBT(root.left.left) + robWithBT(root.left.right))
                + (root.right == null ? 0 : robWithBT(root.right.left) + robWithBT(root.right.right));

        // 不抢 去下家
        int unDoIt = robWithBT(root.left) + robWithBT(root.right);

        int res = Math.max(doIt, unDoIt);
        memo.put(root, res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 3, 6};
        System.out.println(rob(nums));
    }
}
