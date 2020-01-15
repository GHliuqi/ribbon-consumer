package com.alan.ribbonconsumer.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author : <a href="mailto:liuqi@ebnew.com">liuqi</a>
 * @version : v1.0
 * @date :  2020-01-14 16:34
 * @description :
 */
public class MyInterceptor implements HandlerInterceptor {
    //设置在请求controller之前拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器中preHandle被调用");
        Map map = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        System.out.println("preHandle"+map.get("name"));
        System.out.println("preHandle:"+request.getRequestURL());
        System.out.println("preHandle"+request.getParameter("username"));
        if ("zhangsan".equals(map.get("name"))){
            //true则不拦截
            return true;
        }else {
            PrintWriter writer = response.getWriter();
            writer.write("please login again");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("拦截器中postHandle被调用");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截器中afterCompletion被调用");
    }
}
