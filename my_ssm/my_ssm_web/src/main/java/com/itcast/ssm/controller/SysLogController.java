package com.itcast.ssm.controller;

import com.itcast.ssm.domain.SysLog;
import com.itcast.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author:yuyang
 * @data:2019-05-18 11:52
 **/
@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll()throws Exception{
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogs = sysLogService.findAll();
        mv.addObject("sysLogs",sysLogs);
        mv.setViewName("syslog-list");
        return mv;
    }
}
