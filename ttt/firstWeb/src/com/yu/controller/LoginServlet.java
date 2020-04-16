package com.yu.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yu.service.LoginService;
import com.yu.vo.Manager;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends BaseServlet {

	
	//用户注销
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		//从session中将user删除
		session.removeAttribute("user");

		//将存储在客户端的cookie删除掉
		Cookie cookie_username = new Cookie("cookie_username","");
		cookie_username.setMaxAge(0);
		//创建存储密码的cookie
		Cookie cookie_password = new Cookie("cookie_password","");
		cookie_password.setMaxAge(0);

		response.addCookie(cookie_username);
		response.addCookie(cookie_password);


		response.sendRedirect(request.getContextPath()+"/login.jsp");

	}

	//用户登录
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		//获得输入的用户名和密码
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		

		//将用户名和密码传递给service层
		LoginService service = new LoginService();
		Manager user = null;
		try {
			user = service.login(name,pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//判断用户是否登录成功 user是否是null
		if(user!=null){
			session.setAttribute("user", user);
			//重定向到首页
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else{
			request.setAttribute("loginError", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
