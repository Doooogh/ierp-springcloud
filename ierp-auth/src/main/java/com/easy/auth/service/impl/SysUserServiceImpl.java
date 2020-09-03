package com.easy.auth.service.impl;

import com.easy.auth.service.SysUserService;
import com.easy.common.commons.CommonResult;
import com.easy.common.entity.system.SysUser;

/**
 * @Description
 * @Author li long
 * @Date 2020/9/3 23:09
 * @Version 1.0
 **/
public class SysUserServiceImpl implements SysUserService {
    @Override
    public CommonResult<SysUser> findByUsername(String username) {
        return CommonResult.success();
    }
}
