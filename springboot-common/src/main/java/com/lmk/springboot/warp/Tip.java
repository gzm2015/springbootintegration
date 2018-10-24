package com.lmk.springboot.warp;

/**
 * @author LiuMengKe
 * @create 2018-10-24-10:46
 */
public abstract class Tip {

    protected int code;
    protected String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
