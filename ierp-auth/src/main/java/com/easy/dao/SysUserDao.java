package com.easy.dao;

import com.easy.entity.system.SysUser;
import org.apache.ibatis.annotations.Param;

public interface SysUserDao {
    SysUser findByUsername(@Param("username")String username);
}
