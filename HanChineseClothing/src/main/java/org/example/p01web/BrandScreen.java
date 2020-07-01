package org.example.p01web;

import org.example.p04bean.Brand;

import java.util.List;

public class BrandScreen extends BaseScreen{
    public void show() {
        clear();
        System.out.println("=====================================这里是汉服品牌分类页面======================================");
    }

    public void show(List<Brand> list) {
        //创建StringBuilder构造器
        StringBuilder stringBuilder=new StringBuilder();
        //依次打印tab_brand的每一行
        for (int i=0;i<list.size();i++){
            Brand brand=list.get(i);
            stringBuilder.append(brand.getBid()).append(" ").append(brand.getBname()).append("\n");
        }
        System.out.println(stringBuilder.toString());

    }
}
