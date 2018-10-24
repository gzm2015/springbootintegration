package com.lmk.springboot;

import com.lmk.springboot.bean.PageResultBean;
import com.lmk.springboot.entity.SysUserEntity;
import com.lmk.springboot.service.SysUserService;
import com.lmk.springboot.service.impl.UserPageServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author LiuMengKe
 * @create 2018-06-14-15:38
 *
 * 测试分页
 * 不要使用TransactionalConfig.java
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PageUtilTest {
    @Autowired
    UserPageServiceImpl userPageServiceImpl;
    @Autowired
    SysUserService sysUserService;

    @Test
    public void test() {
        SysUserEntity userDTO = new SysUserEntity();
        userDTO.setUsername("aaa");
        userDTO.setPage(2);
        userDTO.setRows(5);
        PageResultBean<SysUserEntity> bean = sysUserService.getPage(userDTO);
        System.out.println(bean);
    }

    @Test
    public void test2() {
        SysUserEntity userDTO = new SysUserEntity();
        userDTO.setUsername("aaa");
        PageResultBean<SysUserEntity> bean = userPageServiceImpl.getPage(userDTO);
        System.out.println(bean);
    }


    @Test
    public void testUserRole() {
        SysUserEntity userDTO = new SysUserEntity();
        userDTO.setUserId(201l);
        SysUserEntity res = sysUserService.selectSysUserWithRole(userDTO);
        System.out.println();
    }
}
