package org.example.service;

import org.example.p02service.BrandService;
import org.example.p02service.ClothService;
import org.example.p04bean.Brand;
import org.example.p04bean.Cloth;
import org.example.p04bean.PageBean;
import org.junit.Test;

import java.util.List;


public class ClothServiceTest {
    //测试类：查询对应汉服品牌旗下的汉服
    @Test
    public void test01FindById() throws Exception {
        //1.创建一个业务类
        ClothService clothService=new ClothService();
        //2.调用查询方法,查询获得的一个分类
        int bid=2;
        List<Cloth> list=clothService.findClothByBid(bid);

        //3.打印结果
        System.out.println(list);

    }
    //测试类：汉服信息页面分类
    @Test
    public void test02FindByBid() throws Exception {
        //1.创建一个业务类
        ClothService clothService=new ClothService();
        //2.调用查询方法,查询获得的一个分类
        int bid=2;
        //参数：品牌id,每页的记录数,当前页
        PageBean<Cloth> pageBean=clothService.queryByPage(bid,4,1);

        //3.打印结果
        System.out.println(pageBean);

    }

}
