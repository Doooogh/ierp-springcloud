package com.easy.client.service;

import com.easy.client.service.impl.FallbackSysUserService;
import com.easy.common.commons.CommonResult;
import com.easy.common.entity.system.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description
 * @Author li long
 * @Date 2020/9/3 16:35
 * @Version 1.0
 **/

@Component
@FeignClient(value = "IERP-ADMIN-SERVICE",fallback = FallbackSysUserService.class)
public interface SysUserService {

    @GetMapping("/sysUser/findByUsername/{username}")
    CommonResult findByUsername(@PathVariable("username") String username);

}
