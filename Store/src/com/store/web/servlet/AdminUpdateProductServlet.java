package com.store.web.servlet;

import com.store.domain.Product;
import com.store.service.AdminProductService;
import com.store.service.impl.AdminProductServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
@WebServlet(name="adminUpdateProduct",urlPatterns = "/adminUpdateProduct")
public class AdminUpdateProductServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //1、获取数据
        Map<String, String[]> properties = request.getParameterMap();
        //2、封装数据
        Product product = new Product();
        try {
            BeanUtils.populate(product, properties);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //此位置Product已经封装完毕----将表单的数据封装完毕
        //手动设置表单中没有数据
        //2）、private String pimage;
        product.setPimage("products/1/c_0033.jpg");
        //3）、private String pdate;//上架日期
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        product.setPdate(date);
        //4）、private int pflag;//商品是否下载 0代表未下架
        product.setPflag(0);

        //3、传递数据给service层
        AdminProductService service = new AdminProductServiceImpl();
        try {
            service.updateProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //跳转到列表页面
        response.sendRedirect(request.getContextPath()+"/admin?method=findAllProducts");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
