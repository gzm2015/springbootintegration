package com.lmk.springboot.exception;

/**
 * Created by LiuMengKe on 2018/10/24.
 */
public enum BizEnum {

    NOT_FOUND(400,"找不到");

    BizEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
    private int code;

    private String message;


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
