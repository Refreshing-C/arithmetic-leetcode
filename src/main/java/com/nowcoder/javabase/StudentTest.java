package com.nowcoder.javabase;

import com.alibaba.fastjson.JSON;

/**
 * author: Administrator
 * create: 2021/7/11 0011
 * description:
 */
public class StudentTest {
    public static void main(String[] args) {
        String json = "{\"name\":\"tom\",\"age\":14,\"birthday\":\"2010-07-12\"}";
        Student s = JSON.parseObject(json, Student.class);
        System.out.println(s);
    }
}
