package com.nowcoder.javabase;

import java.util.concurrent.CountDownLatch;

/**
 * 使用4个子线程求出1到100的和,且每个子线程只能计算25个数,主线程必须等待子线程
 */
public class FourThread {

    static int sum11 = 0;
    static int sum12 = 0;
    static int sum13 = 0;
    static int sum14 = 0;
    static int sum = 0;


    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(4);
        new Thread(() -> {
            int sum1 = 0;
            for (int i = 1; i <= 25; i++) {
                sum1 += i;
            }
            sum11 += sum1;
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + " " + sum11);
        }).start();

        new Thread(() -> {

            int sum2 = 0;
            for (int i = 26; i <= 50; i++) {
                sum2 += i;
            }
            sum12 += sum2;
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + " " + sum12);

        }).start();

        new Thread(() -> {

            int sum3 = 0;
            for (int i = 51; i <= 75; i++) {
                sum3 += i;
            }
            sum13 += sum3;
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + " " + sum13);
        }).start();

        new Thread(() -> {
            int sum4 = 0;
            for (int i = 76; i <= 100; i++) {
                sum4 += i;
            }
            sum14 = sum4;
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + " " + sum14);

        }).start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sum = sum11 + sum12 + sum13 + sum14;
        System.out.println("sum: " + sum);

    }

}