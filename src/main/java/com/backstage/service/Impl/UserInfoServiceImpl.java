package com.backstage.service.Impl;

import com.backstage.dao.UserInfoDao;
import com.backstage.pojo.Role;
import com.backstage.pojo.UserInfo;
import com.backstage.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    protected BCryptPasswordEncoder bCryptPasswordEncoder;
    protected HttpServletRequest request;
    protected UserInfoDao userInfoDao;

    @Autowired
    public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Autowired
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Autowired
    public void setUserInfoDao(UserInfoDao userInfoDao){
        this.userInfoDao = userInfoDao;
    }

    /**
     * 用户的权限操作
     * <p>
     * 根据用户名找到用户。在实际的实现中，搜索可能区分大小写，或者不区分大小写，具体取决于实现实例的配置方式。在这种情况下，
     * 返回的<code> UserDetails </ code> 对象的用户名可能与实际请求的不同。
     *
     * @param username 接收客户端传过来的用户名
     * @return 完全填充的用户记录（从不<null </ null>）
     * @throws UsernameNotFoundException 如果找不到该用户或该用户没有就抛出异常
     */


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoDao.findUserByUsername(username);

        //将查询出的用户信息存入session域中
        userInfo.setLoginTime(new Date());
        request.getSession().setAttribute("userInfo", userInfo);



        //处理自己查询出的用户对象封装成UserDetails

        User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));
        return user;
    }

    /**
     * 返回一个list集合，集合中是角色描述
     *
     * @return
     */
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }


    @Override
    public List<UserInfo> findAllUser(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return userInfoDao.findAllUser();
    }

    @Override
    public void saveUser(UserInfo userInfo) {
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userInfoDao.saveUser(userInfo);

    }

    @Override
    public void updateUserById(String id, String newPassword) {
        newPassword = bCryptPasswordEncoder.encode(newPassword);
        userInfoDao.updateUserById(id, newPassword);
    }

    @Override
    public UserInfo findUserById(String id) {
        return userInfoDao.findUserById(id);
    }

    @Override
    public void deleteUser(String id) {
        userInfoDao.deleteUser_Role(id);
        userInfoDao.deleteUser(id);
    }

    @Override
    public List<Role> findOtherRole(String id) {
        return userInfoDao.findOtherRole(id);
    }

    @Override
    public void saveRoleToUser(String userId, String[] roleIds) {
        for (String roleId : roleIds) {
            userInfoDao.saveRoleToUser(userId, roleId);
        }
    }

    @Override
    public void deleteUserRole(String userId, String roleId) {
        userInfoDao.deleteUserRole(userId, roleId);
    }
}
