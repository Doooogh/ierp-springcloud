package com.easy.admin.service.impl;

import com.easy.admin.dao.SysUserDao;
import com.easy.admin.service.SysUserService;
import com.easy.common.entity.system.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author li long
 * @Date 2020/9/3 16:20
 * @Version 1.0
 **/
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public List<SysUser> list() {
        return sysUserDao.list();
    }

    @Override
    public int save(SysUser sysUser) {
        return sysUserDao.save(sysUser);
    }

    @Override
    public SysUser get(String id) {
        return sysUserDao.get(id);
    }

    @Override
    public int delete(String id) {
        return sysUserDao.delete(id);
    }

    @Override
    public SysUser findByUsername(String username) {
        return sysUserDao.findByUsername(username);
    }
}
