package com.alan.ribbonconsumer.lisenter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author : <a href="mailto:liuqi@ebnew.com">liuqi</a>
 * @version : v1.0
 * @date :  2020-01-14 15:43
 * @description :
 */
@Component
@WebListener
public class LoginLisenter implements ServletRequestListener, ServletContextListener, HttpSessionListener {

    //统计session的数量 即登录人数
    private static int onLine = 0;
    /*-----------application的监听---------------*/
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        //在项目启动的时候被初始化
        System.out.println("执行contextInitialized项目启动了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        //在项目关闭的时候被销毁
        System.out.println("执行contextDestroyed项目关闭了");
    }

    /*-----------request的监听---------------*/
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

        //在当前请求结束的时候被销毁
        System.out.println("当前请求结束要执行requestDestroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

        //在当前请求的时候被初始化
        System.out.println("当前请求开始要执行requestInitialized");
    }

    /*-----------session的监听---------------*/
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //在登录的时候被创建
        ServletContext servletContext = se.getSession().getServletContext();
        servletContext.setAttribute("onLineCount", ++onLine);
        System.out.println("登录的时候创建session");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        //在退出的时候被销毁
        ServletContext servletContext = se.getSession().getServletContext();
        servletContext.setAttribute("onLineCount", --onLine);
        System.out.println("退出的时候销毁session");
    }
}
