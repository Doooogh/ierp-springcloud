package com.easy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description
 * @Author li long
 * @Date 2020/8/7 9:58
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaServer  //说明是一个eureka服务端
public class IerpServer {
    public static void main(String[] args) {
        SpringApplication.run(IerpServer.class,args);
    }
}
