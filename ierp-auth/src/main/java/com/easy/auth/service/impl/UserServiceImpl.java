package com.easy.auth.service.impl;

import com.easy.auth.constant.MessageConstant;
import com.easy.auth.domain.SecurityUser;
import com.easy.auth.service.SysUserService;
import com.easy.common.commons.CommonResult;
import com.easy.common.constant.AuthConstant;
import com.easy.common.entity.system.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description
 * @Author li long
 * @Date 2020/9/3 16:29
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String clientId = request.getParameter("client_id");
        SysUser sysUser;
        CommonResult<SysUser> sysUserRes=null;
        if(AuthConstant.ADMIN_CLIENT_ID.equals(clientId)){
             sysUserRes = sysUserService.findByUsername(username);
        }
        if (null==sysUserRes.getData()) {
            throw new UsernameNotFoundException(MessageConstant.USERNAME_PASSWORD_ERROR);
        }
        sysUser= sysUserRes.getData();
        sysUser.setClientId(clientId);
        SecurityUser securityUser = new SecurityUser(sysUser);
        if (!securityUser.isEnabled()) {
            throw new DisabledException(MessageConstant.ACCOUNT_DISABLED);
        } else if (!securityUser.isAccountNonLocked()) {
            throw new LockedException(MessageConstant.ACCOUNT_LOCKED);
        } else if (!securityUser.isAccountNonExpired()) {
            throw new AccountExpiredException(MessageConstant.ACCOUNT_EXPIRED);
        } else if (!securityUser.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException(MessageConstant.CREDENTIALS_EXPIRED);
        }
        return securityUser;
    }
}
