package com.zr.interceptor;

import com.zr.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        boolean flag = false;
        HttpSession session = request.getSession();
        String requestpath = request.getServletPath();
        System.out.println(requestpath);
        if(session.getAttribute("user") != null){
            System.out.println("用户登录检测通过 "+requestpath+" 登录用户: "+session.getAttribute("user"));
            //TODO: 和数据库校检用户数据
            flag = true;
        }else {
            System.out.println("用户登录检测未通过 "+requestpath);
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
