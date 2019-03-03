package com.example.demo.controller;

import com.example.demo.common.ServerResponse;
import com.example.demo.service.MmallProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rabbit on 2019/3/2.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private MmallProductService mmallProductService;

    @RequestMapping("delete/{productId}")
    public ServerResponse deleteProduct(@PathVariable Integer productId){
        if(mmallProductService.deleteProduct(productId)){
            return ServerResponse.createBySuccessAndMsg("delete successfully!");
        }else{
            return ServerResponse.createByErrorAndMsg("error occured!");
        }
    }

}
