package com.nowcoder.javabase;

/**
 * 思路：将原有字符串转换为json字符串，使用fastjson的json字符串转对象的方法完成
 */
import com.alibaba.fastjson.JSONObject;

public class StudentTest {

	public static void main(String[] args) {
		//将原有字符串加转译符号，变成标准格式的json字符串
		String source = "{\"name\":\"tiger\",\"age\":21,\"birthday\":\"2018-04-08\"}";
		//假设Student类已存在
		Student student = JSONObject.parseObject(source, Student.class);
		System.out.println(student.getAge());

	}
}