package com.lmk.springboot;

import com.lmk.springboot.bean.PageResultBean;
import com.lmk.springboot.dto.SysUserDTO;
import com.lmk.springboot.entity.SysUserEntity;
import com.lmk.springboot.service.SysUserService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author LiuMengKe
 * @create 2018-06-14-11:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
// //使用ignore mvn install 不自动测试当前类方法
public class UserTest {

    @Autowired
    SysUserService sysUserService;

    @Test
    public void testInsert() {
        String username = "aaa";
        for (int i = 0; i < 20; i++) {
            int random = (int)(Math.random()*1000+10);
            SysUserEntity temp = new SysUserEntity(null, -1L, username+random, "123456", "admin", "123456", "admin@163.com", 0,
                    new Date());
            sysUserService.insertSysUserTrans(temp);

        }
    }

    @Test
    public void testSelect() {
        SysUserEntity userEntity = sysUserService.selectSysUserById(121L);
        System.out.println("hello   user  :"+userEntity);
    }


    @Test
    public void testSelectPage() {
        SysUserDTO userDTO = new SysUserDTO();
        userDTO.setUsername("aaa");
        PageResultBean<SysUserEntity> resultBean =  sysUserService.selectSysUserByPage(userDTO);
        System.out.println(resultBean);
    }
}
