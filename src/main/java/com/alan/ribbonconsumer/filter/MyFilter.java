package com.alan.ribbonconsumer.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * @author : <a href="mailto:liuqi@ebnew.com">liuqi</a>
 * @version : v1.0
 * @date :  2020-01-14 16:16
 * @description :
 */
//@Component
//@WebFilter
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter"+servletRequest.getParameter("name"));
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponseWrapper httpServletResponseWrapper = new HttpServletResponseWrapper((HttpServletResponse) servletResponse);
        if (httpServletRequest.getRequestURI().indexOf("/index") != -1 ||
                httpServletRequest.getRequestURI().indexOf("/asd") != -1 ||
                httpServletRequest.getRequestURI().indexOf("/onLine") != -1 ||
                httpServletRequest.getRequestURI().indexOf("/login") != -1){
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            httpServletResponseWrapper.sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {
        System.out.println("过滤器被销毁");
    }
}
