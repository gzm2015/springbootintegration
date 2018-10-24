package com.lmk.springboot.service.impl;

import com.lmk.springboot.dao.SysRoleDAO;
import com.lmk.springboot.entity.SysRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiuMengKe
 * @create 2018-06-15-17:15
 */
@Service
public class RoleServiceImpl {

    @Autowired
    SysRoleDAO sysRoleDAO;

    public void insert(SysRoleEntity roleEntity){
        sysRoleDAO.insert(roleEntity);
    }

}
