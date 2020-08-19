package com.easy.dao;


import com.easy.entity.system.SysRole;

import java.util.List;

/**
 * @Description
 * @Author li long
 * @Date 2020/7/30 10:54
 * @Version 1.0
 **/
public interface SysRoleDao {

    List<SysRole> getRoleByUserId(String userId);

}
