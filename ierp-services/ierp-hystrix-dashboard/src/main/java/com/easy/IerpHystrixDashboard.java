package com.easy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Description
 * @Author li long
 * @Date 2020/8/18 17:01
 * @Version 1.0
 **/
@SpringBootApplication
@EnableHystrixDashboard
public class IerpHystrixDashboard {

    public static void main(String[] args) {
        SpringApplication.run(IerpHystrixDashboard.class,args);
    }
}
