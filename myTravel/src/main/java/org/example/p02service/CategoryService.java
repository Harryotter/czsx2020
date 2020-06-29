package org.example.p02service;

import org.example.bean.Category;
import org.example.p03Dao.CategoryDao;

import java.util.List;

public class CategoryService {
    public List<Category> findAll() throws Exception {
        //创建Dao 对象
        CategoryDao categoryDao=new CategoryDao();
        //调findAll方法
        List<Category> list =categoryDao.findAll();
        //返回
        return list;
    }


}
