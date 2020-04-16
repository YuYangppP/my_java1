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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName MessageServlet.java
 * @Description 添加留言
 * @Date 2019/12/3 14:14
 */
@WebServlet(name = "MessageServlet",urlPatterns = "/MessageServlet")
public class MessageServlet extends HttpServlet {

    private MessService service = new MessageServiceImpl();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request,response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        //获取参数并封装到Message对象
        Map<String, String[]> map = request.getParameterMap();
        Message m = new Message();
        try {
            BeanUtils.populate(m,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        String mtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String ip = request.getRemoteAddr();
        m.setMtime(mtime);
        m.setIp(ip);
        m.setId(0);
        //调用Service保存客户
        service.addMessage(m);
        request.getRequestDispatcher("/MessageUIServlet").forward(request, response);
    }
}
