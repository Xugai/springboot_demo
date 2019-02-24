package com.example.demo.aspect;

import com.example.demo.entity.House;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Created by rabbit on 2019/2/21.
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(public * com.example.demo.controller.HelloController.sayHello(..))")
    public void doSayHelloMethod(){
    }

    @Before("doSayHelloMethod()")
    public void beforeSayHello(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = requestAttributes.getRequest();
        // get requested method (get/post/delete/put/connect)
        System.out.println("requested method: " + httpServletRequest.getMethod());
        // get requested address
        System.out.println("requested address: " + httpServletRequest.getRemoteAddr());
        // get class method
        System.out.println("class method: " + joinPoint.getSignature().getDeclaringTypeName() + " " + joinPoint.getSignature().getName());
        // get requested params
        System.out.print("the requested params are: ");
        Enumeration enumeration = httpServletRequest.getParameterNames();
        if(enumeration.hasMoreElements()){
            String param = (String) enumeration.nextElement();
            System.out.print(param + "=" + httpServletRequest.getParameter(param) + " ");
        }
        System.out.println();
        // get requested parameters
        System.out.println("the class's method parameters are: ");
        for(int i = 0; i <joinPoint.getArgs().length; i++){
            Object argObj = joinPoint.getArgs()[i];
            if(argObj instanceof House){
                House house = (House) argObj;
                System.out.println(house.getType() + " " + house.getAddress() + " " + house.getSize());
            }
        }
        System.out.println("before do log.");
    }

    @After("doSayHelloMethod()")
    public void afterSayHello(){
        System.out.println("after do log.");
    }

    @AfterReturning(returning = "result", pointcut = "doSayHelloMethod()")
    public void afterReturning(Object result) throws JsonProcessingException{
        System.out.println("after return result.");
        System.out.println(new ObjectMapper().writeValueAsString(result));
    }
}
