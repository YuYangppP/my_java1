package com.yu.controller;

import com.alibaba.fastjson.JSON;
import com.yu.dao.TuDao;
import com.yu.vo.Tu;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "TuServlet",urlPatterns = "/TuServlet")
public class TuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TuDao dao = new TuDao();
        List<Map<String, Object>> mapList = null;
        try {
            mapList = dao.findTu();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List list = new ArrayList();
        for(Map<String,Object> map : mapList) {

            try {
                String bname = (String) map.get("bname");
                System.out.println(bname);
                String c = String.valueOf(map.get("c"));
                System.out.println(c);
                Tu tu = new Tu();
                tu.setLabel(bname);
                tu.setValue(c);
                list.add(tu);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        String str = JSON.toJSONString(list);

        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(str);
        out.flush();
        out.close();

    }
}
