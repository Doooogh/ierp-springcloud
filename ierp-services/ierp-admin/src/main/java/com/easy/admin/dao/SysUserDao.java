package com.easy.admin.dao;

import com.easy.common.entity.edu.School;
import com.easy.common.entity.system.SysUser;

import java.util.List;

public interface SysUserDao {
    List<SysUser> list();
    int save (SysUser school);
    SysUser get(String id);
    int delete(String id);
    SysUser findByUsername(String username);
}
