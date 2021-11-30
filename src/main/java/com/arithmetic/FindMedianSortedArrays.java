package com.arithmetic;

/**
 * @author 19045752
 * @create 2020/9/14
 * @description 寻找两个正序数组的中位数
 * method 可以将问题转化为求两个正序数组第k小的元素，在两个数组均有序的情况下，可以使用二分查找的方法
 *      比较两个数组第k/2的元素，若nums1[k/2-1] < nums2[k/2-1]，则nums1[0...k/2-2]都不可能是第k小的元素
 *      若nums1[k/2-1] > nums2[k/2-1]，则nums2[0...k/2-2]都不可能是第k小的元素，
 *      若nums1[k/2-1] = nums2[k/2-1]，则nums1[k/2-1]最多是第k-1小的元素
 *      如果某个数组为空，说明该数组都不可能是第k小的元素，
 *      当排除掉不可能的元素时，同时需要修改k的值，减去已经排除掉的元素个数，当k=1时，返回两个数组未排除的首元素最小值
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {

        int[] nums1 = new int[]{1, 2, 6};
        int[] nums2 = new int[]{3, 4, 5, 9};

        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
        
    }

    private static double findMedianSortedArrays(int[] nums1, int [] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int totalLength = length1 + length2;

        if (totalLength % 2 == 0) {
            return (findKthSmallest(nums1, nums2, totalLength / 2)
                    + findKthSmallest(nums1, nums2, totalLength / 2 + 1)) / 2;
        } else {
            return findKthSmallest(nums1, nums2, totalLength / 2 + 1);
        }
    }

    private static double findKthSmallest(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        int index1 = 0;
        int index2 = 0;

        while (true) {
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }

            if(k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            int halfK = k / 2;
            int tmpIndex1 = Math.min(index1 + halfK, length1) - 1;
            int tmpIndex2 = Math.min(index2 + halfK, length2) - 1;

            if (nums1[tmpIndex1] <= nums2[tmpIndex2]) {
                k -= (tmpIndex1 - index1 + 1);
                index1 = tmpIndex1 + 1;
            } else {
                k -= (tmpIndex2 - index2 + 1);
                index2 = tmpIndex2 + 1;
            }
        }
    }
}