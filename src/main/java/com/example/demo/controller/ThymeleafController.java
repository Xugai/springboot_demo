package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by rabbit on 2019/2/23.
 */
@Controller
@RequestMapping("/thy")
public class ThymeleafController {

    @RequestMapping("index")
    public String index(){
        return "thymeleaf/index";
    }

    @RequestMapping("index/params")
    public String indexWithParams(ModelMap map){
        map.addAttribute("name", "Behe");
        return "thymeleaf/index_params";
    }
}
