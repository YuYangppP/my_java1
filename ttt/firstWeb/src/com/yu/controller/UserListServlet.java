package com.yu.controller;

import com.yu.service.UserService;
import com.yu.vo.BuMen;
import com.yu.vo.PageBean;
import com.yu.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserListServlet",urlPatterns = "/UserListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        UserService service = new UserService();
        String currentPageStr = request.getParameter("currentPage");
        if(currentPageStr==null) {
            currentPageStr="1";
        }
        int currentPage = Integer.parseInt(currentPageStr);
        int currentCount = 4;

        PageBean pageBean = service.findUserListByCid(currentPage,currentCount);

        request.setAttribute("pageBean", pageBean);
        List<User> userlist = service.findAllUser();
        request.setAttribute("userlist",userlist);
        request.getRequestDispatcher("/userList.jsp").forward(request,response);
    }
}
