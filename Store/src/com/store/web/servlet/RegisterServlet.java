package com.store.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import com.store.domain.User;
import com.store.service.UserService;
import com.store.utils.CommonsUtils;
import com.store.utils.MailUtils;

public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*request.setCharacterEncoding("UTF-8");

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
		response.sendRedirect(request.getContextPath()+"/registerSuccess.jsp");*/



	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
