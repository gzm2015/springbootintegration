package com.lmk.springboot.dao;


import com.lmk.springboot.dto.SysUserDTO;
import com.lmk.springboot.entity.SysUserEntity;

import java.util.List;

/**
 * 系统用户dao . <br>
 * 
 * @author hkb <br>
 */
public interface SysUserDAO {

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
    Long deleteSysUserById(Long id);

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
     * 获得SysUser数据集合
     * 
     * @param sysUserDTO
     * 
     * @return
     */
    List<SysUserEntity> selectSysUser(SysUserDTO sysUserDTO);


    SysUserEntity selectSysUserWithRole(SysUserEntity sysUserEntity);
}