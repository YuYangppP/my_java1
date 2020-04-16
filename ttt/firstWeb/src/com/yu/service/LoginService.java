package com.yu.service;

import java.sql.SQLException;

import com.yu.dao.LoginDao;
import com.yu.vo.Manager;

public class LoginService {
	 public Manager login(String name, String pwd) throws SQLException {
		 System.out.println("service");   
		 LoginDao dao = new LoginDao();
	        return dao.login(name,pwd);
	    }
}
