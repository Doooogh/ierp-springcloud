package com.easy.client.service.impl;

import com.easy.client.service.SysUserService;
import com.easy.common.commons.CommonResult;
import com.easy.common.entity.system.SysUser;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author li long
 * @Date 2020/9/3 16:42
 * @Version 1.0
 **/
@Service
public class FallbackSysUserService implements SysUserService {
    @Override
    public CommonResult findByUsername(String username) {
        return CommonResult.success(new SysUser());
    }
}
