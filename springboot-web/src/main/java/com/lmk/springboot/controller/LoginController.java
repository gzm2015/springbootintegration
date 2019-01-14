package com.lmk.springboot.controller;

import com.lmk.springboot.dto.SysUserDTO;
import com.lmk.springboot.warp.FailTip;
import com.lmk.springboot.warp.SuccessTip;
import com.lmk.springboot.warp.Tip;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author LiuMengKe
 * @create 2018-10-23-16:46
 */
@Controller
@EnableTransactionManagement
public class LoginController {

    public static final String REDIRECT = "redirect:";

    /*未登陆访问如 /dashboard的时候被 SpringSecurity 拦截.loginPage("/login") 会访问这里*/
    @RequestMapping("/relog")
    public String relog(){
        return "login";
    }

    @GetMapping(value = {"/loginOnForm"})
    public String loginOnForm(){
        return "login";
    }

    @GetMapping(value = "/dashboard")
    public String dashboard(){
        return "dashboard";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/role")
    public String roleTest(){
        return "dashboard";
    }


    @GetMapping(value="/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }



}
