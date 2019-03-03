package com.example.demo.service;

import com.example.demo.mapper.MmallProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by rabbit on 2019/3/2.
 */
@Service("mmallProductService")
public class MmallProductServiceImpl implements MmallProductService {


    @Autowired
    private MmallProductMapper mmallProductMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    /*
    * 事务中，Propagation的属性介绍：
    * Propagation.REQUIRED:
    *   被该注解标注的方法，若在执行过程中发生了异常，那么在该方法执行期间产生的结果全部都要回滚，
    *   回滚到该方法执行前的状态（当前存在事务便发生回滚，如果不存在也会新建一个事务出来并进行回
    *   滚操作）
    * Propagation.SUPPORTS:
    *   若被该注解标注的方法执行期间发生了异常，如果该方法原本存在一个事务中，那么就进行回滚，否则
    *   也不新建一个事务，之前产生的结果也依旧有效
    *
    * 因此，数据库中的CRUD操作，建议把新增、修改和删除纳入REQUIRED范围，而查询则一般纳入SUPPORTS范围
    * */
    public boolean deleteProduct(Integer productId) {
        int result = mmallProductMapper.deleteProduct(productId);
        if(result > 0){
            int a = 1 / 0;
            return true;
        }
        return false;
    }
}
