package com.yu.controller;

import com.yu.domain.Student;
import com.yu.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName IndexController.java
 * @Description TODO
 * @Date 2020/4/4 18:31
 */
@Controller
@RequestMapping("index")
public class IndexController {

    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("showStudent")
    public String showStudent(){
        return "showStudent";
    }

    @RequestMapping("showOneStudent")
    public String showOneStudent(Model model){
        Student student=new Student(1,"小明","男",22,"1341113311",new Date(),12312312.212331);
        model.addAttribute("student",student);
        return "showOneStudent";
    }

    @RequestMapping("showAllStudent")
    public String showAllStudent(Model model){
        List<Student> students=new ArrayList<>();
        for (int i = 1; i <=5 ; i++) {
            students.add(new Student(i,"小明"+i,i%2==0?"男":"女",22+i,"1341113311"+i,new Date(),12312312312.1899123));
        }
        model.addAttribute("students",students);
        return "showAllStudent";
    }

    @RequestMapping("showObjects")
    public String showObjects(HttpServletRequest request, Model model){

        HttpSession session = request.getSession();

        ServletContext servletContext = request.getServletContext();
        model.addAttribute("name","name_model");
        request.setAttribute("name","name_reqeuest");
        session.setAttribute("name","name_session");
        servletContext.setAttribute("name","name_servletContext");

        return "showObjects";
    }

    @RequestMapping("addUser1")
    @ResponseBody
    public Map<String,Object> addUser1(@DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss") Date birth){
        Map<String,Object> map=new HashMap<>();
        System.out.println(birth.toLocaleString());
        map.put("msg","success");
        return  map;
    }

    @RequestMapping("addUser2")
    @ResponseBody
    public Map<String,Object> addUser2(Date birth){
        Map<String,Object> map=new HashMap<>();
        System.out.println(birth.toLocaleString());
        map.put("msg","success");
        return  map;
    }

    @RequestMapping("getUser")
    @ResponseBody
    public User getUser(){
        return  new User(1,"xiaoming","WUHAN",new Date());
    }

}
