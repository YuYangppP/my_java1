package com.store.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.store.domain.User;
import com.store.service.UserService;
import com.store.utils.CommonsUtils;
import com.store.utils.MD5Utils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;


public class UserServlet extends BaseServlet {

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

	public void register(HttpServletRequest request, HttpServletResponse response) throws IOException{

		request.setCharacterEncoding("UTF-8");

		//获得表单数据
		Map<String, String[]> properties = request.getParameterMap();
		User user = new User();
		try {
			//自己指定一个类型转换器（将String转成Date）
			ConvertUtils.register(new Converter() {
				@Override
				public Object convert(Class clazz, Object value) {
					//将string转成date
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date parse = null;
					try {
						parse = format.parse(value.toString());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					return parse;
				}
			}, Date.class);
			//映射封装
			BeanUtils.populate(user, properties);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		//private String uid;
		user.setUid(CommonsUtils.getUUID());
		//private String telephone;
		user.setTelephone(null);
		//将user传递给service层
		UserService service = new UserService();
		service.regist(user);



		//跳转到注册成功页面
		response.sendRedirect(request.getContextPath()+"/registerSuccess.jsp");
	}

	//用户登录
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		//获得输入的用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);

		//将用户名和密码传递给service层
		UserService service = new UserService();
		User user = null;
		try {
			user = service.login(username,password);
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
