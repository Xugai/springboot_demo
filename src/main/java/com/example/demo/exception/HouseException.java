package com.example.demo.exception;

/**
 * Created by rabbit on 2019/2/22.
 */

/**
 * 注意，spring框架只在发生RuntimeException的时候若存在事务，则会执行事务回滚。
 * 基类Exception的发生不会触发spring框架中事务的回滚！
 */
public class HouseException extends RuntimeException {
    private int code;
    private String msg;

    public HouseException(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
