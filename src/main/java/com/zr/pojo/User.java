package com.zr.pojo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class User {
    private int u_id;
    private int r_id;
    private String roleName;
    @NotBlank(message = "用户名不能为空")
    private String userName;
    @NotBlank(message = "密码不能为空")
    private String password;
    @Length(max = 255)
    private String note;

    public User(){super();}

    public User(int r_id, String userName, String password){
        this.r_id = r_id;
        this.userName = userName;
        this.password = password;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", r_id=" + r_id +
                ", roleName='" + roleName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
