package com.zr.dao;

import com.zr.pojo.User;

public interface UserMapper {
    User selectUserByNamePsd(User user);
}
