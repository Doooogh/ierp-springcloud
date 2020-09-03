package com.easy.auth.service;

import com.easy.common.commons.CommonResult;
import com.easy.common.entity.system.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "IERP-ADMIN-SERVICE")
public interface SysUserService {

    @GetMapping("/findByUsername/{username}")
    CommonResult<SysUser> findByUsername(@PathVariable("username") String username);
}
