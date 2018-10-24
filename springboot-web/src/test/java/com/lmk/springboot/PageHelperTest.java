package com.lmk.springboot;

import com.lmk.springboot.entity.SysRoleEntity;
import com.lmk.springboot.entity.SysUserEntity;
import com.lmk.springboot.service.SysUserService;
import com.lmk.springboot.service.impl.RoleServiceImpl;
import com.lmk.springboot.service.impl.UserPageServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Random;

/**
 * @author LiuMengKe
 * @create 2018-06-14-15:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PageHelperTest {

    @Autowired
    UserPageServiceImpl userPageServiceImpl;

    @Autowired
    SysUserService sysUserService;

    @Autowired
    RoleServiceImpl roleService;


    @Test
    public void testInsert() {
        String username = "aaa";
        for (int i = 0; i < 13; i++) {
            Random ra =new Random();
            int random = ra.nextInt(100000);
            SysUserEntity temp = new SysUserEntity(null, -1L, username+random, "123456", "admin", "123456", "admin@163.com", 0,
                    new Date());
            userPageServiceImpl.inserst(temp);
        }
    }

    @Test
    public void testInsertRole() {

        Random ra =new Random();
        int random = ra.nextInt(100000);

        SysRoleEntity sysRoleEntity = new SysRoleEntity((long)random,"test","test");

        roleService.insert(sysRoleEntity);

    }

}
