package com.easy.dao;


import com.easy.entity.system.SysMenu;

import java.util.List;

/**
 * @Description
 * @Author li long
 * @Date 2020/7/30 16:49
 * @Version 1.0
 **/
public interface SysMenuDao {
    List<SysMenu> getList();
    List<SysMenu> getListByRoleId(String roleId);
}
