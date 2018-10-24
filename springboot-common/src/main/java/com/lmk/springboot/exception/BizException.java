package com.lmk.springboot.exception;

/**
 * @author LiuMengKe
 * @create 2018-10-24-9:12
 */
public class BizException {

    private int code;

    private String message;

    public BizException(BizEnum bizEnum) {
        this.code = bizEnum.getCode();
        this.message = bizEnum.getMessage();
    }

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
