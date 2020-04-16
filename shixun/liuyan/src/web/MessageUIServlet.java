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
import java.util.List;
/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName MessageUIServlet.java
 * @Description 查询信息列表
 * @Date 2019/12/3 14:14
 */
@WebServlet(name = "MessageUIServlet",urlPatterns = "/MessageUIServlet")
public class MessageUIServlet extends HttpServlet {

    private MessService service = new MessageServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");


        List<Message> message = service.findAllMessage();
        request.setAttribute("message",message);
        request.getRequestDispatcher("/success.jsp").forward(request,response);

    }
}
