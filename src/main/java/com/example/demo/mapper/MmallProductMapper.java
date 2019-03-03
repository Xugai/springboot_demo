package com.example.demo.mapper;

import com.example.demo.pojo.MmallProduct;
import com.example.demo.utils.MyMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface MmallProductMapper extends MyMapper<MmallProduct> {

    Integer deleteProduct(Integer productId);
}