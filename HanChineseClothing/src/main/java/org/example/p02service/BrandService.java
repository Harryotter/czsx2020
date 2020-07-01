package org.example.p02service;

import org.example.p03dao.BrandDao;
import org.example.p04bean.Brand;

import java.util.List;

public class BrandService {

    public List<Brand> findAll() throws Exception {
        //创建Dao
        BrandDao brandDao = new BrandDao();
        //调用Dao中的findALL方法
        List<Brand> list= brandDao.findAll();
        //返回数据列表
        return list;


    }
}
