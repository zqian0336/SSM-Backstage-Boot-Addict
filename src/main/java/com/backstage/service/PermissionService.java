package com.backstage.service;

import com.backstage.pojo.Permission;

import java.util.List;

public interface PermissionService {

    void savePermission(Permission permission);

    void deletePermissionById(String id);

    Permission findPermissionById(String id);

    List<Permission> findAllPermission(int page, int pageSize);
}
