package com.bangnd.framework.sys;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

@WebFilter
public class SysFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) servletResponse);
        if(request.getSession().getAttribute("user") != null ||
                request.getRequestURI().indexOf("/login") != -1 ||
                request.getRequestURI().indexOf(".js") != -1 ||
                request.getRequestURI().indexOf(".css") != -1 ||
                request.getRequestURI().indexOf(".png") != -1 ||
                request.getRequestURI().indexOf(".jpg") != -1 ||
                request.getRequestURI().indexOf(".Bootstrap") != -1) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }else {
            wrapper.sendRedirect("/login");
        }
    }
    @Override
    public void destroy() {
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}