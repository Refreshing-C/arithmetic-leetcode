package com.nowcoder.arithmetic;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 * 解题思路：两个相同的数字异或结果为0，对数组中所有的数字进行异或，最后的结果为两个只出现一次的数字异或的值，
 *      这个结果数字的二进制表示至少有一位为1，记做第N位，以第N位是不是1将原数组拆分为两个数组，
 *      两个只出现一次的数字会分别位于两个数组中，再分别对两个数组进行异或，最后得到的就是需要的数字
 */
public class Test40 {

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 11, 3, 11, 7, 2, 5, 9, 2, 1};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce(array, num1, num2);
    }

    public static void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {
        if (array == null || array.length == 0) {
            return;
        }
        int temp = 0;
        for (int value : array) {
            temp = temp ^ value;
        }

        //得到结果中第一位为1的位置
        int n = getFirstOne(temp);

        for (int value : array) {
            //根据数字第n为是否为1将数字划分为两个数组
            if (((value >> n) & 1) == 0) {
                num1[0] = num1[0] ^ value;
            } else {
                num2[0] = num2[0] ^ value;
            }
        }
    }

    //得到结果中第一位为1的位置
    private static int getFirstOne(int temp) {
        int n = 0;
        while ((temp & 1) == 0 && n < 32) {
            temp = temp >> 1;
            n++;
        }
        return n;
    }
}
