package com.easy.admin.service;

import com.easy.common.entity.system.SysUser;

import java.util.List;

public interface SysUserService {

    List<SysUser> list();
    int save (SysUser sysUser);
    SysUser get(String id);
    int delete(String id);
    SysUser findByUsername(String username);

}
