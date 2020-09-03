package com.easy.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description
 * @Author li long
 * @Date 2020/8/13 13:52
 * @Version 1.0
 **/
@SpringBootApplication
@EnableFeignClients  // 开启Feign
@EnableHystrix  //开启客户端降级
@EnableEurekaClient
public class IerpClient {

    public static void main(String[] args) {
        SpringApplication.run(IerpClient.class,args);
    }
}
