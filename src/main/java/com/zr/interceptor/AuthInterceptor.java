package com.zr.interceptor;

import com.zr.pojo.User;
import com.zr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        boolean flag = false;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user != null){
            if(userService.loginCheck(user.getUserName(), user.getPassword()) == null){
                session.removeAttribute("user");
                request.setAttribute("error", "用户信息出错, 请重新登录!");
                request.getRequestDispatcher("/user/login").forward(request,response);
            }else {
                flag = true;
            }
        }else {
            request.setAttribute("error", "登录状态错误, 请重新登录!");
            request.getRequestDispatcher("/user/login").forward(request,response);
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}
