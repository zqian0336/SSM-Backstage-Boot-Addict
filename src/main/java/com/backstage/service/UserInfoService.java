package com.backstage.service;

import com.backstage.pojo.Role;
import com.backstage.pojo.UserInfo;

import java.util.List;

public interface UserInfoService {

    List<UserInfo> findAllUser(int page, int pageSize);

    void saveUser(UserInfo userInfo);

    void updateUserById(String id, String newPassword);

    UserInfo findUserById(String id);

    void deleteUser(String id);

    List<Role> findOtherRole(String id);

    void saveRoleToUser(String userId, String[] roleIds);

    void deleteUserRole(String userId, String roleId);
}
