package com.yu.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;


import com.yu.utils.DataSourceUtils;
import com.yu.vo.P_Emp;

public class RegisterDao extends ConnFactory {
	public int zhuce(P_Emp p) {

		Connection con = null;
		int count = 0;
		try {
			//得到数据库链接
			con = getConnection();
			
			Statement st = con.createStatement();
//			DateFormat df = DateFormat.getDateInstance();

			String sql = "insert into p_emp(name,password,email,mobile) values('"
					+ p.getUsername() + "','" + p.getPassword() + "','" + p.getEmail()
					+ "','" + p.getMobile()+ "')";

			 count = st.executeUpdate(sql);
			System.out.println("count =" + count);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			
			//关闭数据库链接
			close(con);
		}
		return count;

}
}
