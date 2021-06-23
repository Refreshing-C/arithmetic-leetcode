package com.arithmetic;

/**
 * @author 19045752
 * @create 2020/9/14
 * @description 寻找两个正序数组的中位数
 * method 使用插入排序的思想，每次将较小数组的元素插入到新数组中，轮流插入
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {

        /*int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};

        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);*/
        
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[(nums1.length + 1 + nums2.length) / 2];

        // 使用插入排序算法的思想 充分利用有序数组的条件
        // 每次将一个数组的值插入到另一个数组中 插入下一个元素时从插入上一个元素的起始位置开始插入
        if (nums1.length == 0) {
            return nums2[nums2.length / 2];
        }

        if (nums2.length == 0) {
            return nums1[nums1.length / 2];
        }

        int i = 0;
        int a = 0;
        int b = 0;
        while (i < arr.length) {

            while (b < nums1.length && i < arr.length && nums2[a] >= nums1[b]) {
                arr[i] = nums1[b];
                i++;
                b++;
            }
            while (a < nums2.length && i < arr.length && nums2[a] < nums1[b]) {
                arr[i] = nums2[a];
                i++;
                a++;
            }
        }
        return arr[arr.length - 1];
    }
}