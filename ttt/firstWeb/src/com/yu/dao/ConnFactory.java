package com.yu.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnFactory {
	
	
	public static Connection getConnection() {
		Connection  conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8", "root", "123456");

		} catch (Exception e) {
			e.printStackTrace();
		} 

		return conn;
	}
	
	
	/**
	 * �ر����ӣ��ͷ��ڴ�
	 * 
	 * @param con  Connection����
	 * @return 
	 */
	public static void close( Connection con) {
		try {
		
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}
	

}
