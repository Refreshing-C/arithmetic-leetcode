package com.arithmetic.doublepointer;

/**
 * @author 19045752
 * @create 2020/9/29
 * @description
 * @method 使用双指针解题，左右指针相当于容器的两壁，左右指针起始分别位于数组两侧，依次向中间聚拢
 * 每次使用两壁中较短的一个作为容器的高，两壁之间的距离作为容器的底，计算容器面积。
 * 总是将较短的一个移动一格，重新计算面积。
 */
public class MaxArea {

    public static void main(String[] args) {

        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }
}
