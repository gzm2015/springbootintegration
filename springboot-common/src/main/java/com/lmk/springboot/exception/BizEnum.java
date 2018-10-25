package com.lmk.springboot.exception;

/**
 * Created by LiuMengKe on 2018/10/24.
 */
public enum BizEnum {

    NOT_FOUND(400,"找不到");

    BizEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    private int code;

    private String msg;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
