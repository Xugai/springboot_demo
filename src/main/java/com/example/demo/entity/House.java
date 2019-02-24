package com.example.demo.entity;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;

/**
 * Created by rabbit on 2018/5/22.
 */
@Component
//@ConfigurationProperties(prefix = "content")
public class House {


    private String address = "default address";

    private String type = "default type";

    @Min(value = 168, message = "房屋面积不能小于168㎡!")
    private int size;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
