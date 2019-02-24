package com.example.demo.common;

/**
 * Created by rabbit on 2019/2/21.
 */
public enum ResponseCode{
    SUCCESS(1, "校验成功"),
    VALIDATE_FAIL(2, "校验失败"),
    ILLEGAL_ARGUMENT(3, "参数非法");

    private int code;
    private String desc;

    ResponseCode(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return this.code;
    }

    public String getDesc(){
        return this.desc;
    }

}
