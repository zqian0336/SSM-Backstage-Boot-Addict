package com.backstage.controller;

import com.backstage.pojo.Role;
import com.backstage.pojo.UserInfo;
import com.backstage.service.UserInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    protected UserInfoService userInfoService;

    @Autowired
    public void setUserInfoService(UserInfoService userInfoService){
        this.userInfoService = userInfoService;
    }

    @GetMapping("findAllUser")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ModelAndView findAllUser(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "pageSize", required = true, defaultValue = "5") int pageSize) {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfoList = userInfoService.findAllUser(page, pageSize);
        //pageInfo就是一个分页的Bean,里面包含基本的分页信息
        PageInfo pageInfo = new PageInfo(userInfoList);
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("userList", userInfoList);
        mv.setViewName("user-list");
        return mv;
    }

    @PostMapping("saveUser")
    @PreAuthorize("authentication.principal.username=='Spencer' || authentication.principal.username=='admin'")
    public String saveUser(UserInfo userInfo) {
        userInfoService.saveUser(userInfo);
        String view = "redirect:findAllUser";
        return view;
    }

    @GetMapping("updateUserById")
    public void updateUserById(String id, String newPassword, HttpServletRequest request, HttpServletResponse response) throws IOException {
        userInfoService.updateUserById(id, newPassword);
        //调用Spring security的退出请求路径
        response.sendRedirect(request.getContextPath() + "/logout");
    }


    @GetMapping("findUserById")
    public ModelAndView findUserById(String id) {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userInfoService.findUserById(id);
        mv.addObject("user", userInfo);
        mv.setViewName("user-show");
        return mv;
    }


    @GetMapping("deleteUser")
    @PreAuthorize("authentication.principal.username=='Spencer'")
    public String deleteUser(String id) {
        userInfoService.deleteUser(id);
        String View = "redirect:findAllUser";
        return View;
    }

    @GetMapping("findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(String id) {
        ModelAndView mv = new ModelAndView();
        //根据用户的id查询用户
        UserInfo userInfo = userInfoService.findUserById(id);
        //根据用户的id查询除已有的角色还可以添加的角色
        List<Role> otherRoles = userInfoService.findOtherRole(id);
        mv.addObject("user", userInfo);
        mv.addObject("roleList", otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }


    @PostMapping("saveRoleToUser")
    public String saveRoleToUser(String userId, String[] RoleIds) {
        userInfoService.saveRoleToUser(userId, RoleIds);
        String View = "redirect:findUserByIdAndAllRole?id=" + userId + "";
        return View;
    }


    @GetMapping("deleteUserRole")
    public String deleteUserRole(String userId, String roleId) {
        userInfoService.deleteUserRole(userId, roleId);
        String View = "redirect:findUserByIdAndAllRole?id=" + userId + "";
        return View;
    }


}
