package com.zr.dao;

import com.zr.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Select("select * from user u left join role r on u.r_id = r.r_id where u.userName=#{userName} and u.password=#{password}")
    User findUserByNameAndPassword(@Param("userName")String userName, @Param("password")String password);

    @Select("SELECT u.u_id,u.r_id,u.userName,u.note,r.roleName FROM user u LEFT JOIN role r on u.r_id = r.r_id")
    List<User> getAllUser();

    @Delete("delete from user where u_id=#{u_id} ")
    int delUserByUID(@Param("u_id")int u_id);

    @Update("update user u set u.r_id=#{r_id} where u_id=#{u_id}")
    int changeRoleByUID(@Param("u_id")int u_id, @Param("r_id")int r_id);

    @Select("select roleName from role where r_id=#{r_id}")
    String getRoleNameByRID(@Param("r_id")int r_id);

    @Select("select userName from user where u_id=#{u_id}")
    String getUsernameByUID(@Param("u_id")int u_id);

    @Select("select * from user where userName=#{name}")
    User ifExist(@Param("name")String name);

    int updateUser(User user);

    int changePasswdByUID(User user);

    int addUser(User user);

}
