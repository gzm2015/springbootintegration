package com.lmk.springboot.warp;

/**
 * @author LiuMengKe
 * @create 2018-10-24-10:49
 */
public class FailTip extends Tip{
    public FailTip() {
        this.code = 200;
        this.msg = "fail";
    }
}
