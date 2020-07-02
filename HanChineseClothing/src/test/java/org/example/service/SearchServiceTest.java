package org.example.service;

import org.example.p02service.BrandService;
import org.example.p02service.ClothService;
import org.example.p04bean.Brand;
import org.example.p04bean.Cloth;
import org.example.p04bean.PageBean;
import org.junit.Test;

import java.util.List;


public class SearchServiceTest {
    @Test
    public void test01FindByKeyword() throws Exception {
        //1.创建一个汉服衣服详情业务方法类
        ClothService clothService=new ClothService();
        //2.关键词搜索：调用搜索方法(搜索以分页形式展现)
        PageBean<Cloth> pageBean=clothService.search("齐腰",4,1);

        //3.打印结果
        System.out.println(pageBean);

    }

}
