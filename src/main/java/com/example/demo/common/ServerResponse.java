package com.example.demo.common;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * Created by rabbit on 2019/2/21.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable{
    private int responseCode;
    private T data;
    private String msg;

    private ServerResponse(int responseCode){
        this.responseCode = responseCode;
    }

    private ServerResponse(int responseCode, T data){
        this.responseCode = responseCode;
        this.data = data;
    }

    private ServerResponse(int responseCode, String msg){
        this.responseCode = responseCode;
        this.msg = msg;
    }

    public static <T> ServerResponse <T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse <T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), data);
    }

    public static <T> ServerResponse <T> createBySuccessAndMsg(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> ServerResponse <T> createByError(){
        return new ServerResponse<T>(ResponseCode.VALIDATE_FAIL.getCode());
    }

    public static <T> ServerResponse <T> createByErrorAndMsg(String msg){
        return new ServerResponse<T>(ResponseCode.VALIDATE_FAIL.getCode(), msg);
    }

    public static <T> ServerResponse <T> createByErrorCodeAndMsg(int code, String msg){
        return new ServerResponse<T>(code, msg);
    }

    public int getResponseCode() {
        return responseCode;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }
}
