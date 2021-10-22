package com.yr.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	/**
	 * 连接数据库
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException           1、加载驱动。记得导驱动jar包。 2、连接数据库 3、 私有的方法。仅本类使用。
	 */
	public static Connection getCons() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC", "root", "daraole.");
			return conn;
		} catch (Exception e) {
			return null;
		}
	}
	
}
