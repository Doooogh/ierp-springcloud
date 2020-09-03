package com.easy.ierptest;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @Description
 * @Author li long
 * @Date 2020/8/13 14:01
 * @Version 1.0
 **/

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient // 获取EureKa中的服务信息
@EnableFeignClients // 开启Feign
@MapperScan("com.easy.ierptest")
public class IerpTest {
    public static void main(String[] args) {
        SpringApplication.run(IerpTest.class,args);
    }


    /**
     * @Author li long
     * @Description --该配置是为了服务监控而萍一直，与服务容错本身无关  springcloud升级后的一个坑
     * ServletRegistrationBean因为springboot的默认路径不是  /hystrix.stream
     * 只要在自己的项目里面配置上下面的servlet就可以了
     * @Date 2020/8/5 17:55
     * @Param []
     * @return org.springframework.boot.web.servlet.ServletRegistrationBean
     **/
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
