package com.store.web.servlet;

import com.store.domain.Category;
import com.store.domain.Product;
import com.store.service.AdminProductService;
import com.store.service.AdminService;
import com.store.service.impl.AdminProductServiceImpl;
import com.store.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet(name="adminUpdateProductUI-+*",urlPatterns = "/adminUpdateProductUI")

public class AdminUpdateProductUIServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获得要查询Product的pid
        String pid = request.getParameter("pid");
        //传递pid查询商品信息
        AdminService service = new AdminServiceImpl();
        Product product = null;
        try {
            product = service.findProductByPid(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //获得所有的商品的类别数据
        List<Category> categoryList = null;
        categoryList = service.findAllCategory();


        request.setAttribute("categoryList", categoryList);
        request.setAttribute("product", product);

        request.getRequestDispatcher("/admin/product/edit.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }
}
