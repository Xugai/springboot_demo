package com.example.demo.controller;

import com.example.demo.common.ServerResponse;
import com.example.demo.entity.House;
import com.example.demo.entity.Person;
import com.example.demo.exception.HouseException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by rabbit on 2018/5/22.
 */
@RestController  // @RestController = @Controller + @ResponseBody
public class HelloController {

    @Autowired
    private Person person;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ServerResponse sayHello(@Valid House house, BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            throw new HouseException(101, bindingResult.getFieldError().getDefaultMessage());
//            return ServerResponse.createByErrorAndMsg(bindingResult.getFieldError().getDefaultMessage());
        }
        Person p = new Person();
        BeanUtils.copyProperties(person, p);
        return ServerResponse.createBySuccess(p);
    }
}
