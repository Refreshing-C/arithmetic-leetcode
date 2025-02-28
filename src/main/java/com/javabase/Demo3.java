package com.javabase;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * String、StringBuffer、StringBuilder
 */
public class Demo3 {

    public static void main(String[] args) {
        String s = "abc";
        String ss = "ok" + s + "xyz" + 5;
        String sss = s + 5;

        LocalDateTime ldt = LocalDateTime.now();

        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getMonth());
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getHour());
        System.out.println(ldt.getMinute());
        System.out.println(ldt.getSecond());
        LocalDate ld = LocalDate.now();
    }
}
