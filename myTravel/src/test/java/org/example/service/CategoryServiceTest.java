package org.example.service;


import org.example.p04bean.Category;
import org.example.p02service.CategoryService;
import org.junit.Test;

import java.util.List;


public class CategoryServiceTest {
    @Test
    public void test01FindAll() throws Exception {
        //
        CategoryService categoryService=new CategoryService();
        //
        List<Category> list=categoryService.findAll();
        //
        System.out.println(list);

    }

}
