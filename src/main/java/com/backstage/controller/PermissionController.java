package com.backstage.controller;

import com.backstage.pojo.Permission;
import com.backstage.service.PermissionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/permission")
public class PermissionController {

    protected PermissionService permissionService;

    @Autowired
    public void setPermissionService(PermissionService permissionService){
        this.permissionService = permissionService;
    }

    @GetMapping("findAllPermission")
    public ModelAndView findAllPermission(int page, int pageSize){
        ModelAndView mv = new ModelAndView();
        List<Permission> permissionList = permissionService.findAllPermission(page, pageSize);
        PageInfo pageInfo = new PageInfo(permissionList);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("permissionList", permissionList);
        mv.setViewName("permission-list");
        return mv;
    }

    @PostMapping("savePermission")
    public String savePermission(Permission permission){
        permissionService.savePermission(permission);
        String view = "redirect:findAllPermission";
        return view;
    }

    @GetMapping("findPermissionById")
    public ModelAndView findPermissionById(String id){
        ModelAndView mv = new ModelAndView();
        Permission permission = permissionService.findPermissionById(id);
        mv.addObject("permission", permission);
        mv.setViewName("permission-show");
        return mv;
    }

    @GetMapping("deletePermissionById")
    public String deletePermissionById(String id){
        permissionService.deletePermissionById(id);
        String view = "redirect:findAllPermission";
        return view;
    }

}
