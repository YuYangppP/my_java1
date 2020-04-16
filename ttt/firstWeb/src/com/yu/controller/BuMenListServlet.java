package com.yu.controller;

import com.yu.service.BuMenService;
import com.yu.service.UserService;
import com.yu.vo.BuMen;
import com.yu.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "BuMenListServlet",urlPatterns = "/BuMenListServlet")
public class BuMenListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=UTF-8");

        BuMenService service = new BuMenService();
        List<BuMen> buMenList = service.findAllBuMen();
        System.out.println(buMenList);
        request.setAttribute("buMenList",buMenList);
        request.getRequestDispatcher("/bumen.jsp").forward(request,response);

/*
        String mtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
*/
    }
}
