package web;

import domain.Message;
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
 * @ClassName UpdateMessageUIServlet.java
 * @Description 编辑信息回显
 * @Date 2019/12/3 14:14
 */
@WebServlet(name = "UpdateMessageUIServlet",urlPatterns = "/UpdateMessageUIServlet")
public class UpdateMessageUIServlet extends HttpServlet {
    private MessService service = new MessageServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int ids = Integer.parseInt(id);
        Message mes = service.findMessageById(ids);
        request.setAttribute("mes",mes);
        request.getRequestDispatcher("/edit.jsp").forward(request,response);
    }
}
