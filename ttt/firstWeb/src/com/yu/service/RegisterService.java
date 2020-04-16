package com.yu.service;

import java.sql.SQLException;




import com.yu.dao.RegisterDao;
import com.yu.vo.P_Emp;

public class RegisterService {
	public int zhuce(P_Emp p) {

		RegisterDao dao = new RegisterDao();

		int count = dao.zhuce(p);

		return count;

	}
}
