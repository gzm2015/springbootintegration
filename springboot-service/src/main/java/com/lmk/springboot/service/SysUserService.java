package com.lmk.springboot.service;


import com.lmk.springboot.bean.PageResultBean;
import com.lmk.springboot.dto.SysUserDTO;
import com.lmk.springboot.entity.SysUserEntity;

import java.util.List;

/**
 * 系统用户接口 . <br>
 * 
 * @author hkb <br>
 */
public interface SysUserService {

    /**
     * 插入SysUser到数据库
     * 
     * @param sysUserEntity
     * @return
     */
    Long insertSysUser(SysUserEntity sysUserEntity);

    /**
     * 通过SysUser的id更新SysUser中的数据
     * 
     * @param sysUserEntity
     * @return
     */
    Long updateSysUserById(SysUserEntity sysUserEntity);

    /**
     * 通过SysUser的id删除SysUser
     * 
     * @param id
     * @return
     */
    Boolean deleteSysUserById(Long id);

    /**
     * 通过username和id查询用户名是否存在
     * 
     * @param sysUserEntity
     * @return
     */
    Integer selectUsername(SysUserEntity sysUserEntity);

    /**
     * 通过SysUser的id获得SysUser对象
     * 
     * @param id
     * @return
     */
    SysUserEntity selectSysUserById(Long id);

    /**
     * 分页查询SysUser
     * 
     * @param sysUserDTO
     * @return
     */
    PageResultBean<SysUserEntity> selectSysUserByPage(SysUserEntity sysUserEntity);


    /**
     * 插入SysUser到数据库
     *
     * @param sysUserEntity
     * @return
     */
    Long insertSysUserTrans(SysUserEntity sysUserEntity);


    PageResultBean<SysUserEntity> getPage(SysUserEntity sysUserEntity);

    /**
     * 返回用户及其权限
     */
    SysUserEntity selectSysUserWithRole(SysUserEntity sysUserEntity);


    PageResultBean<SysUserEntity> getPageByDTO(SysUserDTO dto);
}