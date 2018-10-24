package com.lmk.springboot;

import com.lmk.springboot.entity.SysUserEntity;
import com.lmk.springboot.service.SysUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.Date;

@SpringBootApplication
@MapperScan("com.lmk.springboot.dao")
@EnableTransactionManagement
public class SpringbootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebApplication.class, args);
    }

    @Autowired
    SysUserService sysUserService;

    //在application-dev.yml 配置context-path为my  访问 http://localhost:8080/my/hello
    /*
    *插入数据是失败的时候 先试一下查询  查询结果也没得 又不报错 重新写一下 yml 文件
    */
    /*
    * pagehelper
    * https://github.com/abel533/MyBatis-Spring-Boot
    *
    * 注意 web模块的插件要用人家的 先跑一遍他的项目以后  mvn:mybatis-generator:generate 生成一下
    * 这插件用来 mybatis-generator generatorConfig.xml放置好
    *
    * 另外注意SpringbootWebApplication 里面那个 @MapperScan 要用 tk包下面的
    *
    * dao层中 要加mapper-spring-boot-starter 依赖
    * pagehelper 插入数据时 实体类名和 表名不对应 在实体类上使用 @Table进行 修改
    *
    */
    /*
    * 这种多模块的项目 每个模块scr文件夹下面的根文件夹最好一致
    */


    /*@GetMapping("/hello/saveuser")
    public String saveUser(){
        String username = "aaa";
        for (int i = 0; i < 20; i++) {
            int random = (int)(Math.random()*1000+10);
            SysUserEntity temp = new SysUserEntity(null, -1L, username+random, "123456", "admin", "123456", "admin@163.com", 0,
                    new Date());
            sysUserService.insertSysUserTrans(temp);
        }
        return "hello spring boot";
    }*/





}
