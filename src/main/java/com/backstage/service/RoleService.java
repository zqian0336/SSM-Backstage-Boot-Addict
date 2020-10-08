package com.backstage.service;

import com.backstage.pojo.Permission;
import com.backstage.pojo.Role;

import java.util.List;

public interface RoleService {

    void saveRole(Role role);

    void deleteById(String id);

    Role findRoleById(String id);

    List<Role> findAllRole(int page, int pageSize);

    List<Permission> findOtherPermission(String id);

    void savePermissionToRole(String roleId, String[] permissionIds);

    void deleteRolePermission(String roleId, String permissionId);
}
