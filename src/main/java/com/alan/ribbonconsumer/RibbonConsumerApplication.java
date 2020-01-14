package com.alan.ribbonconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@EnableCircuitBreaker //hystrix断路器注解
//@EnableDiscoveryClient  //启动Eureka客户端注解
//@SpringBootApplication
@SpringCloudApplication //包含@EnableCircuitBreaker和@EnableDiscoveryClient还有@SpringBootApplication
@ServletComponentScan(basePackages = {"com.alan.ribbonconsumer.listener", "com.alan.ribbonconsumer.filter"})
public class RibbonConsumerApplication {

    @Bean   //spring容器管理
    @LoadBalanced   //Ribbon负载均衡注解
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(RibbonConsumerApplication.class, args);
    }

}
