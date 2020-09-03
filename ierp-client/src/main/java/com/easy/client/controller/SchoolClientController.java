package com.easy.client.controller;

import com.easy.client.service.SchoolService;
import com.easy.common.commons.CommonResult;
import com.easy.common.entity.edu.School;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author li long
 * @Date 2020/8/13 15:04
 * @Version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/client/school/")
@DefaultProperties(defaultFallback = "ierp_Global_FallbackMethod")  //统一配置服务降级
public class SchoolClientController {


    @Autowired
    private SchoolService schoolService;

    @GetMapping("/list")
    public CommonResult list(){
        return schoolService.list();
    }




    //全局fallback方法
    public CommonResult ierp_Global_FallbackMethod(){
        return CommonResult.error();
    }


    @GetMapping("/get/{id}")
    public CommonResult get(@PathVariable("id") String id){
        return schoolService.get(id);
    }

    @PostMapping("/save")
    public CommonResult save(School school){
        return schoolService.save(school);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResult delete(@PathVariable("id")String id){
        return schoolService.delete(id);
    }


    @GetMapping("/testDuan/{id}")
    @HystrixCommand(fallbackMethod = "testDuanRongFallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500"),  //请求超时 或者服务错误
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸*//*
    })
    public CommonResult testDuan(@PathVariable("id") Long id) throws Exception {
        if(id<0){
            throw new Exception();
        }
        return schoolService.testDuan(id);
    }

    public CommonResult testDuanRongFallback(@PathVariable("id") Long id){
        return CommonResult.errorOfMessage("80熔断了。。++++++："+id);
    }


      /* @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500"),  //请求超时 或者服务错误
           *//* @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸*//*
    })*/




}
