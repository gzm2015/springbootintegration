package com.lmk.springboot.service.impl;

import com.github.pagehelper.util.StringUtil;
import com.lmk.springboot.entity.SysUserEntity;
import com.lmk.springboot.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginSecurityService implements UserDetailsService {

    @Autowired
    SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String userInput) throws UsernameNotFoundException {
        SysUserEntity entity = new SysUserEntity();
        entity.setUsername(userInput);
        SysUserEntity userWithRole = sysUserService.selectSysUserWithRole(entity);
        if (StringUtil.isEmpty(userInput)||userWithRole == null) {
            //避免返回null，这里返回一个不含有任何值的User对象，在后期的密码比对过程中一样会验证失败
            return new SysUserEntity();
        }
        return userWithRole;
    }
}
