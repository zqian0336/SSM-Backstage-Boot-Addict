package com.backstage.controller;

import com.backstage.pojo.SysLog;
import com.backstage.service.SysLogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    protected SysLogService sysLogService;

    @Autowired
    public void setSysLogService(SysLogService sysLogService) {
        this.sysLogService = sysLogService;
    }

    @GetMapping("findAllSysLog")
    public ModelAndView findAllSysLog(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "pageSize", required = true, defaultValue = "5") int pageSize) {
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogList = sysLogService.findAllSyslog(page, pageSize);
        //pageInfo就是一个分页的Bean,里面包含基本的分页信息
        PageInfo pageInfo = new PageInfo(sysLogList);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("sysLogs", sysLogList);
        mv.setViewName("syslog-list");
        return mv;
    }

    @GetMapping("deleteSysLogById")
    public void deleteSysLogById(String id) {
        sysLogService.deleteSyslogById(id);
    }
}
