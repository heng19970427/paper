package com.zr.controller;

import com.zr.pojo.User;
import com.zr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private QuesController quesController;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage(){ return "login"; }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView loginCheck(HttpServletRequest request, User user){
        User isUser =  userService.loginCheck(user);
        ModelAndView mv = new ModelAndView();
        if (isUser==null) {
            mv.addObject("error","用户名或密码错误");
            mv.setViewName("login");
        } else {
            request.getSession().setAttribute("user", isUser);
            mv.addObject("msg", "欢迎回来");
            mv.setViewName("forward:/question/list");
        }
        return mv;
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "login";
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
