package com.easy.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description
 * @Author li long
 * @Date 2020/8/18 23:11
 * @Version 1.0
 **/
@EnableFeignClients // 开启Feign
@EnableEurekaClient
@EnableDiscoveryClient // 获取EureKa中的服务信息
@SpringBootApplication(scanBasePackages = "com.easy.auth")
public class IerpAuth {
    public static void main(String[] args) {
        SpringApplication.run(IerpAuth.class,args);
    }
}
