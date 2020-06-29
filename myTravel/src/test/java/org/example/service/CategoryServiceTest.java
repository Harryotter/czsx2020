package org.example.service;


import org.example.bean.Category;
import org.example.bean.User;
import org.example.p02service.CategoryService;
import org.example.p02service.UserService;
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
