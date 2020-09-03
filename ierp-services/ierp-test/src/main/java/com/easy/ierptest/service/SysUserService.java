package com.easy.ierptest.service;

import com.easy.common.commons.CommonResult;
import com.easy.common.entity.system.SysUser;
import com.easy.ierptest.service.impl.FallbackSysUserService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "IERP-ADMIN-SERVICE",fallback = FallbackSysUserService.class)
public interface SysUserService {

    @GetMapping("/findByUsername/{username}")
    CommonResult<SysUser> findByUsername(@PathVariable("username") String username);
}
