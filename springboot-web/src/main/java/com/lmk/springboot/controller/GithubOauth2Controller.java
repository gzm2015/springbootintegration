package com.lmk.springboot.controller;

import com.lmk.springboot.warp.SuccessTip;
import com.lmk.springboot.warp.Tip;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author LiuMengKe
 * @create 2019-01-12-18:54
 */
@Controller
public class GithubOauth2Controller {



    /**
     * https://github.com/login/oauth/authorize?client_id=client_id(https://github.com/settings/applications/找)&state=randomnumber&redirect_uri=url(不填按配置来)
     */
    @GetMapping("/callback")
    @ResponseBody
    public Tip callback(String code, String state,String redirect_uri,String client_secret,String access_token,HttpServletRequest request){
        System.out.println("github 回调接口获取参数 "+code);
        System.out.println("github 回调接口获取参数 "+state);
        System.out.println("github 回调接口获取参数 "+redirect_uri);
        System.out.println("github 回调接口获取参数 "+client_secret);
        return new SuccessTip();
    }

}
