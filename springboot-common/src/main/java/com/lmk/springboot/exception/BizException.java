package com.lmk.springboot.exception;

/**
 * @author LiuMengKe
 * @create 2018-10-24-9:12
 */
public class BizException {

    private int code;

    private String msg;

    public BizException(BizEnum bizEnum) {
        this.code = bizEnum.getCode();
        this.msg = bizEnum.getMsg();
    }

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
