package com.alan.ribbonconsumer.myConfig;

import com.alan.ribbonconsumer.Interceptor.MyInterceptor;
import com.alan.ribbonconsumer.filter.MyFilter;
import com.alan.ribbonconsumer.lisenter.LoginLisenter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author : <a href="mailto:liuqi@ebnew.com">liuqi</a>
 * @version : v1.0
 * @date :  2020-01-14 16:47
 * @description :
 */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/asd/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/zxc/foo").setViewName("foo");
    }

    /*
    * 将过滤器配置注册到服务中
    */
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());//创建需要注册的过滤器的对象
        filterRegistrationBean.addUrlPatterns("/*");//设置过滤的路径
        filterRegistrationBean.setName("MyFilter");//设置过滤器的名称
        filterRegistrationBean.setOrder(1);//设置过滤器的执行顺序  数字越小越先执行
        System.out.println("MyWebConfig配置注册filter");
        return filterRegistrationBean;
    }

    /*
     * 将监听器配置注册到服务中
     */
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new LoginLisenter());//创建需要注册的监听器的对象
        System.out.println("MyWebConfig配置注册listener");
        return servletListenerRegistrationBean;
    }
}
