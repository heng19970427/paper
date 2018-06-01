package com.zr.controller;

import com.zr.pojo.User;
import com.zr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
        User isUser =  userService.loginCheck(userName,password);
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

    @RequestMapping("userManage")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView("userManage");
        List<User> users = userService.getAllUser();
        mv.addObject("users",users);
        return mv;
    }
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public QuesController getQuesController() {
        return quesController;
    }

    public void setQuesController(QuesController quesController) {
        this.quesController = quesController;
    }
}
