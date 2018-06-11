package com.zr.interceptor;

import com.zr.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        boolean flag = false;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user.getRoleName().equals("manager")){
            flag = true;
        }else {
            request.setAttribute("error", "用户权限不足, 只有管理员可以访问!");
            request.getRequestDispatcher("/question/list").forward(request,response);
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
