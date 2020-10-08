package com.backstage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/action")
public class Routing {

    @GetMapping("forwardProductAdd")
    public String forwardProductAdd() {
        return "product-add";
    }

    @GetMapping("forwardChangePassword")
    public String forwardChangePassword(){
        return "changePassword";
    }

    @GetMapping("forwardUserAdd")
    public String forwardUserAdd(){
        return "user-add";
    }

    @GetMapping("forwardRoleAdd")
    public String forwardRoleAdd(){
        return "role-add";
    }

    @GetMapping("forwardPermissionAdd")
    public String forwardPermissionAdd(){
        return "permission-add";
    }


}
