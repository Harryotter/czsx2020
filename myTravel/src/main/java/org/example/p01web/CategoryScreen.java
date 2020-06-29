package org.example.p01web;

import org.example.bean.Category;

import java.util.List;

public class CategoryScreen extends BaseScreen{
    public void show() {
        clear();
        System.out.println("==================这里是旅游分类=================");
    }

    public void show(List<Category> list) {
        clear();
        System.out.println("==================这里是旅游分类=================");
        StringBuilder stringBuilder=new StringBuilder();

        for(int i=0;i<list.size();i++){
            Category category=list.get(i);
            //stringBuilder拼接字符串
            stringBuilder.append(category.getCid()).append(" ").append(category.getCname()).append("\n");

        }
        System.out.println(stringBuilder.toString());
        }


}
