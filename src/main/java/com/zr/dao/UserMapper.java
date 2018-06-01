package com.zr.dao;

import com.zr.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from user u left join role r on u.r_id = r.r_id where u.userName=#{userName} and u.password=#{password}")
    User findUserByNameAndPassword(@Param("userName")String userName, @Param("password")String password);

    @Select("SELECT * FROM `user` LEFT JOIN role on user.r_id = role.r_id")
    List<User> getAllUser();

}
