package com.yu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yu.service.RegisterService;

import com.yu.vo.P_Emp;

@WebServlet(name = "RegisterServlet",urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	//get
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
	
		doPost(request,response);
		
	}

	//post
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		///======================================
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		//=====================================
		P_Emp p =new P_Emp();
		p.setUsername(uname);
		p.setPassword(pwd);
		p.setEmail(email);
		
		p.setMobile(mobile);
		 
		
		//========================================
		
		RegisterService  service =new RegisterService();
		int count  = service.zhuce(p);
		
		
		//=========count=1 添加成功login.jsp    count !=1  zhuce.jsp============================
		if(count == 1){
		request.setAttribute("msg","恭喜您登陆成功");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
//		else{
//			
//			request.setAttribute("msg","用户名密码不对，请重新登陆");
//			request.getRequestDispatcher("/login.jsp").forward(request, response);
//			
//		}
	}

}