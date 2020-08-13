package com.easy;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @Author li long
 * @Date 2020/8/13 14:01
 * @Version 1.0
 **/

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient // 获取EureKa中的服务信息
@MapperScan("com.easy.dao")
public class IerpTest {
    public static void main(String[] args) {
        SpringApplication.run(IerpTest.class,args);
    }
}
