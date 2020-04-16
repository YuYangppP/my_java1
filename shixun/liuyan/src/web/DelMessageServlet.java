package web;

import service.MessService;
import service.impl.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName DelMessageServlet.java
 * @Description 单个删除
 * @Date 2019/12/3 14:14
 */
@WebServlet(name = "DelMessageServlet",urlPatterns = "/DelMessageServlet")
public class DelMessageServlet extends HttpServlet {
    private MessService service = new MessageServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id1 = request.getParameter("id");
        int id = Integer.parseInt(id1);
        service.delMessage(id);
        response.sendRedirect(request.getContextPath()+"/MessageUIServlet");
    }
}
