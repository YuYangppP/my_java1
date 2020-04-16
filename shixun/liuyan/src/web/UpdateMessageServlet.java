package web;

import domain.Message;
import org.apache.commons.beanutils.BeanUtils;
import service.MessService;
import service.impl.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName UpdateMessageServlet.java
 * @Description 更新信息
 * @Date 2019/12/3 14:14
 */
@WebServlet(name = "UpdateMessageServlet",urlPatterns = "/UpdateMessageServlet")
public class UpdateMessageServlet extends HttpServlet {
    private MessService service = new MessageServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        Message m = new Message();
        try {
            BeanUtils.populate(m,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(m.getId());
        service.updateMessage(m);
        response.sendRedirect(request.getContextPath()+"/MessageUIServlet");
    }
}
