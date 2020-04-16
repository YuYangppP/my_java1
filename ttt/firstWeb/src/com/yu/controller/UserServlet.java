package com.yu.controller;

import com.google.gson.Gson;
import com.yu.service.BuMenService;
import com.yu.service.UserService;
import com.yu.vo.BuMen;
import com.yu.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName UserDao.java
 * @Description TODO
 * @Date 2020/2/26 15:16
 */
@WebServlet(name = "UserServlet",urlPatterns = "/UserServlet")
public class UserServlet extends BaseServlet {


	public void findAllBuMen1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService service = new UserService();
		List<BuMen> bumenList = service.findAllBuMen1();

		Gson gson = new Gson();
		String json = gson.toJson(bumenList);

		response.setContentType("text/html;charset=UTF-8");

		response.getWriter().write(json);
	}

	//更新时回显员工信息
	public void updateUserUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String id = request.getParameter("uid");
		int uid = Integer.parseInt(id);
		UserService service = new UserService();
		User user = service.updateUserUI(uid);
		request.setAttribute("user",user);
		request.getRequestDispatcher("/editUserInfo.jsp").forward(request,response);
	}

	//员工删除
	public void delUserById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("uid");
		int uid = Integer.parseInt(id);
		UserService service = new UserService();

		service.delUser(uid);
		response.sendRedirect(request.getContextPath()+"/UserListServlet");
	}

	//更新信息
	public void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        String id = request.getParameter("uid");
        String id1 = request.getParameter("bid");
        int bid = Integer.parseInt(id1);
        int uid = Integer.parseInt(id);
        User user = new User();
        user.setName(name);
        user.setNumber(tel);
        user.setUid(uid);
        user.setBmid(bid);
        System.out.println(user.toString());
        UserService service = new UserService();
        service.updateUser(user);
        request.getRequestDispatcher("/UserListServlet").forward(request,response);
	}


	//添加员工
	public void addUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");

		//获取参数并封装到Message对象
		String name = request.getParameter("uname");
		String number = request.getParameter("number");
		String id = request.getParameter("bid");
		int bid = Integer.parseInt(id);
		User user = new User();

		user.setUid(0);
		user.setName(name);
		user.setNumber(number);
		user.setBmid(bid);
		UserService service = new UserService();
		//调用Service保存客户 URIEncoding="UTF-8
		service.addUser(user);
		request.getRequestDispatcher("/UserListServlet").forward(request, response);
	}

}
