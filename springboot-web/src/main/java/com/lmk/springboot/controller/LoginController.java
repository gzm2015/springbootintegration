package com.lmk.springboot.controller;

import com.lmk.springboot.dto.SysUserDTO;
import com.lmk.springboot.warp.FailTip;
import com.lmk.springboot.warp.SuccessTip;
import com.lmk.springboot.warp.Tip;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiuMengKe
 * @create 2018-10-23-16:46
 */
@Controller
@EnableTransactionManagement
public class LoginController {

    public static final String REDIRECT = "redirect:";

    /*未登陆访问如 /dashboard的时候被 SpringSecurity 拦截.loginPage("/login") 会访问这里*/
    @GetMapping("/login")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public Tip index(){
        return new FailTip();
    }

    @GetMapping(value = {"/index"})
    public String login(){
       return "login";
    }

    @GetMapping(value = "/dashboard")
    public String dashboard(){
        return "dashboard";
    }
}
