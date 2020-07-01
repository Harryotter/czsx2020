package org.example.service;

import org.example.p02service.BrandService;
import org.example.p02service.UserService;
import org.example.p04bean.Brand;
import org.example.p04bean.User;
import org.junit.Test;

import java.util.List;


public class BrandServiceTest {
    @Test
    public void test01FindAll() throws Exception {
        //1.创建一个业务类
        BrandService brandService=new BrandService();
        //2.调用查询方法
        List<Brand> list=brandService.findAll();

        //3.打印结果
        System.out.println(list);

    }

}
