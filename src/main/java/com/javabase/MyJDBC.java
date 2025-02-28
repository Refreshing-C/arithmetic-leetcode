package com.javabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyJDBC {
	
//	driverclass: com.mysql.jdbc.Driver 
//	connection URL: jdbc:mysql://127.0.0.1:3306/test 
//	username:root 
//	password:000000
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		//假设Student类已存在
		Student student = new Student();
		student.setName("tiger");
		student.setAge(21);
		student.setBirthday("2018-04-08");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://110.40.137.198:3306/test", "root", "123456");
			String sql = "insert into t_user(id, name, age) values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 3);
			ps.setString(2, student.getName());
			ps.setInt(3, student.getAge());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
