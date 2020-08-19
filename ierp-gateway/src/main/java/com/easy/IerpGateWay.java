package com.easy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description
 * @Author li long
 * @Date 2020/8/19 20:08
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient // 获取EureKa中的服务信息
public class  IerpGateWay {
    public static void main(String[] args) {
        SpringApplication.run(IerpGateWay.class,args);

    }
}
