package com.easy.ierptest.controller;

import com.easy.common.commons.CommonResult;
import com.easy.common.entity.system.SysUser;
import com.easy.ierptest.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author li long
 * @Date 2020/9/3 22:49
 * @Version 1.0
 **/
@RestController
@RequestMapping("/testCon")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/sysUser/getByUsername/{username}")
    public CommonResult<SysUser> getByUsername(@PathVariable("username") String username){
        return sysUserService.findByUsername(username);
    }
}
