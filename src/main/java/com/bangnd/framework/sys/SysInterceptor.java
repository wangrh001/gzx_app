package com.bangnd.framework.sys;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SysInterceptor implements HandlerInterceptor {
    //在请求处理之前进行调用（Controller方法调用之前)
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//        System.out.println("preHandle被调用");
//        HttpSession session = httpServletRequest.getSession();
//        //判断是否已有该用户登录的session
//        if(session.getAttribute("user") != null){
//            return true;
//        }
//        //跳转到登录页
//        String url = "/ums/login";
//        httpServletResponse.sendRedirect(url);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
