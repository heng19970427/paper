package com.zr.service;

import com.zr.dao.UserMapper;
import com.zr.pojo.User;
import com.zr.utils.Digest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findUserByNameAndPassword(String userName, String password) {
        return userMapper.findUserByNameAndPassword(userName, password);
    }

    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    public int delUserByUID(int u_id) {
        return userMapper.delUserByUID(u_id);
    }

    public int addUser(User user) {
        String password = Digest.digestPassword(user.getPassword());
        if (password != null) {
            user.setPassword(password);
            return userMapper.addUser(user);
        } else
            return 0;

    }

    public int changePasswdByUID(User user) {
        return userMapper.changePasswdByUID(user);
    }

    public int changeRoleByUID(int u_id, int r_id) {
        return userMapper.changeRoleByUID(u_id, r_id);
    }

    public String getRoleNameByRID(int r_id) {
        return userMapper.getRoleNameByRID(r_id);
    }

    public String getUsernameByUID(int u_id) {
        return userMapper.getUsernameByUID(u_id);
    }

    public int updateUser(User user) {
        if (user.getPassword() != null){
            String password = Digest.digestPassword(user.getPassword());
            user.setPassword(password);
        }
        return userMapper.updateUser(user);
    }

    public User ifExist(String name){
        return userMapper.ifExist(name);
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
