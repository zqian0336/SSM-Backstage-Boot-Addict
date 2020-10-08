package com.backstage.controller;

import com.backstage.pojo.Permission;
import com.backstage.pojo.Role;
import com.backstage.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {

    protected RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("findAllRole")
    public ModelAndView findAllRole(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "pageSize", required = true, defaultValue = "5") int pageSize) {
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAllRole(page, pageSize);
        mv.addObject("roleList", roleList);

        //pageInfo就是一个分页的Bean,里面包含基本的分页信息
        PageInfo pageInfo = new PageInfo(roleList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("role-list");
        return mv;
    }

    @PostMapping("saveRole")
    public String saveRole(Role role) {
        roleService.saveRole(role);
        String View = "redirect:findAllRole";
        return View;
    }

    @GetMapping("deleteRole")
    public String deleteRole(String id) {
        roleService.deleteById(id);
        String view = "redirect:findAllRole";
        return view;
    }

    @GetMapping("findRoleById")
    public ModelAndView findRoleById(String id) {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findRoleById(id);
        mv.addObject("role", role);
        mv.setViewName("role-show");
        return mv;
    }

    @GetMapping("findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermission(String id) {
        ModelAndView mv = new ModelAndView();
        //根据角色的id查询角色
        Role role = roleService.findRoleById(id);
        //根据用户的id查询除已有的角色还可以添加的角色
        List<Permission> otherPermissions = roleService.findOtherPermission(id);
        mv.addObject("role", role);
        mv.addObject("permissionList", otherPermissions);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @PostMapping("savePermissionToRole")
    public String savePermissionToRole(String roleId, String[] PermissionIds) {
        roleService.savePermissionToRole(roleId, PermissionIds);
        String view = "redirect:findRoleByIdAndAllPermission?id="+roleId+"";
        return view;
    }

    @GetMapping("deleteRolePermission")
    public String deleteRolePermission(String roleId, String permissionId) {
        roleService.deleteRolePermission(roleId, permissionId);
        String view = "redirect:findRoleByIdAndAllPermission?id="+roleId+"";
        return view;
    }
}
