package com.yu.controller;

import com.yu.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DelSelectServlet",urlPatterns = "/DelSelectServlet")
public class DelSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
       /* String[] infos = request.getParameterValues("info");
        for (int i = 0;i<infos.length;i++){
            int id = Integer.parseInt(infos[i]);
            service.delMessage(id);
        }*/
        String checkId = request.getParameter("checkId");
        String[] split = checkId.split(",");
        UserService service = new UserService();
        int[] ids = new int[split.length];
        System.out.println(ids.length);
        if(split.length>0){
            for (int i=0;i<split.length;i++){

                ids[i] = Integer.parseInt(split[i]);

            }
        }
        for (int id : ids){
            service.delAllUser(id);
        }

        response.sendRedirect(request.getContextPath()+"/UserListServlet");
    }

}
