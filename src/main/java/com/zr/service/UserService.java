package com.zr.service;

import com.zr.dao.UserMapper;
import com.zr.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User loginCheck(String userName, String password) {
        return userMapper.findUserByNameAndPassword(userName, password);
    }

    public List<User> getAllUser(){
        return userMapper.getAllUser();
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
