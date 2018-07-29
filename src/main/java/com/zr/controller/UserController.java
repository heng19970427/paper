package com.zr.controller;

import com.zr.pojo.Response;
import com.zr.pojo.User;
import com.zr.service.UserService;
import com.zr.utils.Digest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    private QuesController quesController;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage(){ return "login"; }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView loginCheck(HttpServletRequest request,
                                   @RequestParam("userName")String userName,
                                   @RequestParam("password")String password){
        if (password != null){
            password = Digest.digestPassword(password);
        }else
            password = "";
        User isUser =  userService.findUserByNameAndPassword(userName,password);
        ModelAndView mv = new ModelAndView();
        if (isUser!=null) {
            request.getSession().setAttribute("user", isUser);
            mv.addObject("msg", "欢迎回来,"+isUser.getUserName());
            mv.setViewName("forward:/question/list");
        } else {
            mv.addObject("error","用户名或密码错误");
            mv.setViewName("login");
        }
        return mv;
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "login";
    }

    @RequestMapping("man/getAllUser")
    @ResponseBody
    public Object getAllUser(){
        return userService.getAllUser();
    }
    @RequestMapping("man/userManage")
    public String list(){
        return "userManage";
    }
    @RequestMapping("man/delUserByUID")
    @ResponseBody
    public Object del(@RequestParam("u_id")int u_id,HttpSession session){
        System.out.println("del: u_id="+u_id);
        Response response = new Response();
        int code;
        User user = (User) session.getAttribute("user");
        String username = userService.getUsernameByUID(u_id);
        if (user.getU_id()==u_id){
            code = 2;
            response.setError("不能删除自己!");
        }else {
            if(userService.delUserByUID(u_id) == 1){
                code = 0;
                response.setMsg("删除 "+username+" 成功!");
            }else {
                code = 1;
                response.setError("删除 "+username+" 失败!");
            }
        }
        response.setCode(code);
        return response;
    }

    @RequestMapping("man/addUser")
    @ResponseBody
    public Object addUser(@Valid @RequestBody User add_user, Errors errors){
        System.out.println("add: "+add_user.toString());
        Response response = new Response();
        int code = -1;
        if (errors.hasErrors()){
            if (errors.hasFieldErrors("userName") || errors.hasFieldErrors("password")){
                code = 3;
                response.setError("用户名,密码不能为空");
            }else if (errors.hasFieldErrors("note")){
                code = 3;
                response.setError("备注最长为255个字符");
            }
        }else {
            if (userService.ifExist(add_user.getUserName()) == null){
                if (userService.addUser(add_user) == 1){
                    code = 0;
                    response.setMsg("添加成功!");
                }else {
                    code = 1;
                    response.setError("添加失败!");
                }
            }else {
                code = 2;
                response.setError("用户名已存在, 添加失败!");
            }
        }
        response.setCode(code);
        return response;
    }

    @RequestMapping("man/updateUser")
    @ResponseBody
    public Object updateUser(@Valid @RequestBody User update_user, Errors errors){
        System.out.println("update: "+update_user.toString());
        Response response = new Response();
        int code;
        if (errors.hasErrors()){
            if (errors.hasFieldErrors("password")){
                errors.getFieldError("password");
            }
        }
        User u = userService.ifExist(update_user.getUserName());
        if (u == null || u.getUserName().equals(update_user.getUserName())){
            if (userService.updateUser(update_user) == 1){
                code = 0;
                response.setMsg("修改成功!");
            }else {
                code = 1;
                response.setError("修改失败!");
            }
        }else {
            code = 2;
            response.setError("用户名已存在, 修改失败!");
        }
        response.setCode(code);
        return response;
    }
}
