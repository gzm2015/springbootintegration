package com.lmk.springboot.controller;

import com.lmk.springboot.bean.PageResultBean;
import com.lmk.springboot.dto.SysUserDTO;
import com.lmk.springboot.entity.SysUserEntity;
import com.lmk.springboot.service.SysUserService;
import com.lmk.springboot.warp.Tip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiuMengKe
 * @create 2019-01-12-14:02
 */
@Controller
public class UserController {

    @Autowired
    SysUserService sysUserService;

    @GetMapping("/user/list")
    public String  list(Model model){
        SysUserEntity userEntity = new SysUserEntity();
        PageResultBean<SysUserEntity>  list = sysUserService.getPageByDTO(new SysUserDTO());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        SysUserEntity loginUser = (SysUserEntity)auth.getPrincipal();//当前登录的对象
        String loginUserName = (String)auth.getName();//名字
        model.addAttribute("name",loginUserName);
        model.addAttribute("list",list);
        return "/user/list";
    }


}
