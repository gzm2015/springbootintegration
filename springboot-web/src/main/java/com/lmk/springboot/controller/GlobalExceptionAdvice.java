package com.lmk.springboot.controller;


import com.lmk.springboot.exception.CheckException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiuMengKe
 * @create 2018-10-24-9:09
 */
@ControllerAdvice
public class GlobalExceptionAdvice {

    public static final String ERROR_PAGE_NAME = "error";

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map handleException(Exception e){
        Map map = new HashMap();
        map.put("message",e.getMessage());
        System.out.println(e.getMessage());
        return map;
    }

    @ExceptionHandler(CheckException.class)
    @ResponseBody
    public Map handleException(CheckException e){
        Map map = new HashMap();
        map.put("message",e.getMessage());
        System.out.println(e.getMessage());
        return map;
    }

}
