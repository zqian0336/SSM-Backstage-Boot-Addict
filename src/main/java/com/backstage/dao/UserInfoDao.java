package com.backstage.dao;

import com.backstage.pojo.Role;
import com.backstage.pojo.UserInfo;

import java.util.List;

public interface UserInfoDao {

    UserInfo findUserByUsername(String username);

    List<UserInfo> findAllUser();

    void saveUser(UserInfo userInfo);

    void updateUserById(String id, String newPassword);

    UserInfo findUserById(String id);

    void deleteUser(String id);

    void deleteUser_Role(String id);

    List<Role> findOtherRole(String id);

    void saveRoleToUser(String userId, String roleId);

    void deleteUserRole(String userId, String roleId);
}
