package com.easy.common.config;


import com.easy.common.config.entity.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.easy.controller")
                .title("ierp认证中心")
                .description("ierp认证中心相关接口文档")
                .contactName("ierp")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
