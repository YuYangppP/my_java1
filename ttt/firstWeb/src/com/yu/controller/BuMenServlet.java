package com.yu.controller;

import com.yu.service.BuMenService;
import com.yu.utils.Tools;
import com.yu.vo.BuMen;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "BuMenServlet",urlPatterns = "/BuMenServlet")
public class BuMenServlet extends BaseServlet {


    public void addBuMen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        String bname = request.getParameter("bname");
        String leader = request.getParameter("leader");
        String tel = request.getParameter("tel");
        String mtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        BuMen buMen = new BuMen();
        buMen.setBid(0);
        buMen.setBname(bname);
        buMen.setLeader(leader);
        buMen.setTelephone(tel);
        buMen.setCreateTime(Tools.stringToDate(mtime));

        BuMenService service = new BuMenService();
        service.addBuMen(buMen);

        request.getRequestDispatcher("/BuMenListServlet").forward(request,response);
    }

    public void delBuMen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("bid");
        int bid = Integer.parseInt(id);
        BuMenService service = new BuMenService();

        service.delBuMen(bid);
        response.sendRedirect(request.getContextPath()+"/BuMenListServlet");
    }

    public void updateBuMen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        String bname = request.getParameter("bname");
        String leader = request.getParameter("leader");
        String tel = request.getParameter("tel");
        String id = request.getParameter("bid");
        int bid = Integer.parseInt(id);
        BuMen buMen = new BuMen();
        buMen.setBname(bname);
        buMen.setLeader(leader);
        buMen.setTelephone(tel);
        buMen.setBid(bid);
        BuMenService service = new BuMenService();
        service.updateBuMen(buMen);
        request.getRequestDispatcher("/BuMenListServlet").forward(request,response);
    }
    public void updateBuMenUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        String id = request.getParameter("bid");
        int bid = Integer.parseInt(id);
        BuMenService service = new BuMenService();
        BuMen buMen = service.findBuMenById(bid);
        request.setAttribute("buMen",buMen);
        request.getRequestDispatcher("/editBuMen.jsp").forward(request,response);
    }
}
