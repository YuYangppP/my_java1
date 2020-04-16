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
 * @ClassName DelSelectServlet.java
 * @Description  多选删除
 * @Date 2019/12/3 14:14
 */
@WebServlet(name = "DelSelectServlet",urlPatterns = "/DelSelectServlet")
public class DelSelectServlet extends HttpServlet {
    private MessService service = new MessageServiceImpl();

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

        int[] ids = new int[split.length];
        System.out.println(ids.length);
        if(split.length>0){
            for (int i=0;i<split.length;i++){

                ids[i] = Integer.parseInt(split[i]);

            }
        }
        for (int id : ids){
            service.delMessage(id);
        }

        response.sendRedirect(request.getContextPath()+"/MessageUIServlet");
    }
}
