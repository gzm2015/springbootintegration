package com.lmk.springboot.service.impl;


import com.github.pagehelper.PageHelper;
import com.lmk.springboot.bean.PageResultBean;
import com.lmk.springboot.dao.SysUserDAO;
import com.lmk.springboot.dto.SysUserDTO;
import com.lmk.springboot.entity.SysUserEntity;
import com.lmk.springboot.exception.CheckException;
import com.lmk.springboot.service.SysUserService;
import com.lmk.springboot.util.CheckUtils;
import com.lmk.springboot.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 用户接口实现类 . <br>
 * 
 * @author hkb <br>
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    /**
     * 注入系统用户dao
     */
    @Autowired
    private SysUserDAO sysUserDAO;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Long insertSysUser(SysUserEntity sysUserEntity) {
        int check = selectUsername(sysUserEntity);
        if (check > 0) {
            throw new CheckException("用户名已存在");
        }
        sysUserDAO.insertSysUser(sysUserEntity);
        return sysUserEntity.getUserId();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Long updateSysUserById(SysUserEntity sysUserEntity) {
        CheckUtils.notNull(sysUserEntity.getUserId(), "id不能为空");
        // 数据库是否已有这个用户名
        int check = selectUsername(sysUserEntity);
        if (check > 0) {
            throw new CheckException("用户名已存在");
        }
        sysUserDAO.updateSysUserById(sysUserEntity);
        return sysUserEntity.getUserId();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean deleteSysUserById(Long id) {
        boolean isDelete = false;
        long result = sysUserDAO.deleteSysUserById(id);
        if (result > 0) {
            isDelete = true;
        }
        return isDelete;
    }

    @Override
    public Integer selectUsername(SysUserEntity sysUserEntity) {
        String username = sysUserEntity.getUsername();
        CheckUtils.notEmpty(username, "用户名不能为空");
        return sysUserDAO.selectUsername(sysUserEntity);
    }

    @Override
    public SysUserEntity selectSysUserById(Long id) {
        return sysUserDAO.selectSysUserById(id);
    }

    @Override
    public PageResultBean<SysUserEntity> selectSysUserByPage(SysUserDTO sysUserDTO) {
        PageHelper.startPage(PageUtils.getPageNum(), PageUtils.getPageSize());
        return new PageResultBean<SysUserEntity>(sysUserDAO.selectSysUser(sysUserDTO));
    }

    @Transactional
    @Override
    public Long insertSysUserTrans(SysUserEntity sysUserEntity) {
        sysUserDAO.insertSysUser(sysUserEntity);
        return sysUserEntity.getUserId();
    }


    @Override
    public PageResultBean<SysUserEntity> getPage(SysUserEntity sysUserEntity){
       /* if (sysUserEntity.getPage() != null && sysUserEntity.getRows() != null) {
            PageHelper.startPage(sysUserEntity.getPage(), sysUserEntity.getRows());
        }
        Example example = new Example(SysUserEntity.class);
        Example.Criteria criteria = example.createCriteria();
        if (sysUserEntity.getUsername()!=null) {
            criteria.andLike("username", "%" + sysUserEntity.getUsername() + "%");
        }
        List<SysUserEntity> list =  sysUserDAO.selectSysUserWithRole(sysUserEntity);
        return new PageResultBean<SysUserEntity>(list);*/
       return null;
    }

    @Override
    public SysUserEntity selectSysUserWithRole(SysUserEntity sysUserEntity) {
        return sysUserDAO.selectSysUserWithRole(sysUserEntity);
    }
}