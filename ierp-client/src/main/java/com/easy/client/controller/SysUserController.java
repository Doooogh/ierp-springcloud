package com.easy.client.controller;

import com.easy.client.service.SysUserService;
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
 * @Date 2020/9/3 16:34
 * @Version 1.0
 **/
@RestController
@RequestMapping("/sysUser")
public class SysUserController {



    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/findByUsername/{username}")
    public CommonResult findByUsername(@PathVariable("username") String username){
        return sysUserService.findByUsername(username);

    }
}
