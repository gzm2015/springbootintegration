package com.lmk.springboot.controller;

import com.lmk.springboot.dto.SysUserDTO;
import com.lmk.springboot.warp.SuccessTip;
import com.lmk.springboot.warp.Tip;
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

    @GetMapping("/login")
    public String index(){
        return "index";
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public Tip login(@RequestBody SysUserDTO userDTO){
        System.out.println("+++++++++++++++++++"+userDTO);
        return new SuccessTip();
    }

    @GetMapping(value = "/dashboard")
    public String dashboard(){
        return "dashboard";
    }
}
