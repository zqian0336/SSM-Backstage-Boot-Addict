package com.backstage.dao;

import com.backstage.pojo.Permission;
import com.backstage.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {

    int saveRole(Role role);

    int deleteById(String id);

    void deleteUsers_Role(String id);

    void deleteRole_permission(String id);

    Role findRoleById(String id);

    List<Role> findAllRole();

    List<Permission> findOtherPermission(String id);

    void savePermissionToRole( String roleId,  String permissionId);

    //Disconnect the relationship between roleId and permissionId
    void deleteRolePermission(String roleId, String permissionId);


}
