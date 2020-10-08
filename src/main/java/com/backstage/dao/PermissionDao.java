package com.backstage.dao;

import com.backstage.pojo.Permission;

import java.util.List;

public interface PermissionDao {

    int savePermission(Permission permission);

    int deletePermissionById(String id);

    int deleteRole_permissionById(String id);

    Permission findPermissionById(String id);

    List<Permission> findAllPermission();
}
