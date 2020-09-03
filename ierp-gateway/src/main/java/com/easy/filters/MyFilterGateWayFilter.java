package com.easy.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.Set;

/**
 * @Description
 * @Author li long
 * @Date 2020/8/19 22:12
 * @Version 1.0
 **/
@Component
@Slf4j
public class MyFilterGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.error("*********come in MyFilterGateWayFilter: "+new Date());
        MultiValueMap<String, String> queryParams = exchange.getRequest().getQueryParams();
        Set<String> strings = queryParams.keySet();
        for (String string : strings) {
            log.warn("key:"+string+",value:_________");
            System.out.println(queryParams.get(string));
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
