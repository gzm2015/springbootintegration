package com.lmk.springboot;

import com.lmk.springboot.dao.SysUserDAO;
import com.lmk.springboot.entity.SysUserEntity;
import com.lmk.springboot.service.SysUserService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;


public class SpringbootWebApplicationTests extends BaseTest{

    //模拟 一个userDao对象
    @MockBean
    SysUserDAO sysUserDAO;

    //service 使用 @Service 注解 放入容器 这里注入
    @Autowired
    SysUserService sysUserService;


    //测试注入 注入失败可能 @MapperScan 没有填写
    @Test
    public void testInject() {
        System.out.println(sysUserDAO);
    }

    @Test
    public void testInject2() {
        System.out.println(sysUserService);
    }


    /**
     * 系统用户实体
     */
    private SysUserEntity sysUserEntity;

    /**
     * id
     */
    private Long id = -99L;

    /**
     * 用户名
     */
    private String username = "admin";

    /**
     * 所有测试方法执行之前执行该方法
     */
   /* @Before
    public void before() {
        sysUserEntity = new SysUserEntity(id, -1L, username, "123456", "admin", "123456", "admin@163.com", 0,
                new Date());
        // 设置模拟对象的返回预期值
        Mockito.when(sysUserDAO.insertSysUser(sysUserEntity)).thenReturn(id);
    }*/

    @Test
    public void insertSysUser() {
        // 执行测试
        long userId = sysUserService.insertSysUser(sysUserEntity);
        // 验证
        Assert.assertThat(userId, Matchers.is(id));
        // 得到一个抓取器
        ArgumentCaptor<SysUserEntity> personCaptor = ArgumentCaptor.forClass(SysUserEntity.class);
        // 验证模拟对象的save()是否被调用一次,并抓取调用时传入的参数值
        Mockito.verify(sysUserDAO).insertSysUser(personCaptor.capture());
        // 获取抓取到的参数值
        SysUserEntity addSysUser = personCaptor.getValue();
        // 验证调用时的参数值
        Assert.assertThat(username, Matchers.is(addSysUser.getUsername()));
    }


    /*@Test
    public void testInsert() {

        for (int i = 0; i < 20; i++) {

            SysUserEntity temp = new SysUserEntity(null, -1L, username, "123456", "admin", "123456", "admin@163.com", 0,
                    new Date());
            sysUserService.insertSysUserTrans(temp);

        }

    }*/


    @Test
    public void testSelect() {
        SysUserEntity userEntity = sysUserService.selectSysUserById(10L);
        System.out.println("hello   user  :"+userEntity);
    }



}
