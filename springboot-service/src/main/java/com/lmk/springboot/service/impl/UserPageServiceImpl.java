package com.lmk.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.lmk.springboot.bean.PageResultBean;
import com.lmk.springboot.dao.UserPageDao;
import com.lmk.springboot.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author LiuMengKe
 * @create 2018-06-14-15:40
 * 使用pageHelper的servcie进行分页
 */
@Service
public class UserPageServiceImpl {

    @Autowired
    private UserPageDao userPageDao;

    public PageResultBean<SysUserEntity> getPage(SysUserEntity sysUserEntity){
            if (sysUserEntity.getPage() != null && sysUserEntity.getRows() != null) {
                PageHelper.startPage(sysUserEntity.getPage(), sysUserEntity.getRows());
            }
            Example example = new Example(SysUserEntity.class);
            Example.Criteria criteria = example.createCriteria();

            if (sysUserEntity.getUsername()!=null) {
                criteria.andLike("username", "%" + sysUserEntity.getUsername() + "%");
            }
            List list =  userPageDao.selectByExample(example);

            return new PageResultBean<SysUserEntity>(list);
    }

    //临时用来测试一下 jdk8新特性 接口里面写方法
    @Transactional
    public void inserst(SysUserEntity sysUserEntity){
        userPageDao.insert(sysUserEntity);
    }

}
