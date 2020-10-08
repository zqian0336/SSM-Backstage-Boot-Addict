package com.backstage.service.Impl;

import com.backstage.dao.PermissionDao;
import com.backstage.pojo.Permission;
import com.backstage.service.PermissionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    protected PermissionDao permissionDao;

    @Autowired
    public void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    @Override
    public void savePermission(Permission permission) {
        permissionDao.savePermission(permission);
    }

    @Override
    public void deletePermissionById(String id) {
        permissionDao.deleteRole_permissionById(id);
        permissionDao.deletePermissionById(id);

    }

    @Override
    public Permission findPermissionById(String id) {
        return permissionDao.findPermissionById(id);
    }

    @Override
    public List<Permission> findAllPermission(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return permissionDao.findAllPermission();
    }
}
