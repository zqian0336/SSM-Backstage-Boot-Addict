package com.backstage.service.Impl;

import com.backstage.dao.RoleDao;
import com.backstage.pojo.Permission;
import com.backstage.pojo.Role;
import com.backstage.service.RoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    protected RoleDao roleDao;

    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }


    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    @Override
    public void deleteById(String id) {
        roleDao.deleteUsers_Role(id);
        roleDao.deleteRole_permission(id);
        roleDao.deleteById(id);
    }

    @Override
    public Role findRoleById(String id) {
        return roleDao.findRoleById(id);
    }

    @Override
    public List<Role> findAllRole(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return roleDao.findAllRole();
    }

    @Override
    public List<Permission> findOtherPermission(String id) {
        return roleDao.findOtherPermission(id);
    }

    @Override
    public void savePermissionToRole(String roleId, String[] permissionIds) {
        for(String permissionId : permissionIds) {
            roleDao.savePermissionToRole(roleId, permissionId);
        }
    }

    @Override
    public void deleteRolePermission(String roleId, String permissionId) {
        roleDao.deleteRolePermission(roleId, permissionId);
    }
}
