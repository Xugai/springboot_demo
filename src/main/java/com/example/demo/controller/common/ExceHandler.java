package com.example.demo.controller.common;

import com.example.demo.common.ServerResponse;
import com.example.demo.exception.HouseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by rabbit on 2019/2/22.
 */
@ControllerAdvice
public class ExceHandler {

    private static final String ERROR_VIEW = "error";


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handleException(HttpServletRequest httpServletRequest, Exception ex){
        if(ex instanceof HouseException){
            System.out.println("Catch customized exception.!");
            System.out.println("Requested url is: " + httpServletRequest.getRequestURL().toString());
            HouseException houseException = (HouseException) ex;
            return ServerResponse.createByErrorCodeAndMsg(houseException.getCode(), houseException.getMsg());
        }
        System.out.println("Catch Exception.");
        ex.printStackTrace();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("requestedUrl", httpServletRequest.getRequestURL());
        modelAndView.addObject("errMsg", ex.getMessage());
        modelAndView.setViewName(ERROR_VIEW);
        return modelAndView;
    }
}
