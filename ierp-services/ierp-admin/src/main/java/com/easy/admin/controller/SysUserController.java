package com.easy.admin.controller;

import com.easy.admin.service.SysUserService;
import com.easy.common.commons.CommonResult;
import com.easy.common.entity.system.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author li long
 * @Date 2020/9/3 16:21
 * @Version 1.0
 **/

@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/findByUsername/{username}")
    public CommonResult findByUsername(@PathVariable("username") String username){
        SysUser sysUser= sysUserService.findByUsername(username);
        return CommonResult.success(sysUser);
    }
}
