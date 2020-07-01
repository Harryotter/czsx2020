package org.example.p01web;

import org.example.p04bean.Brand;
import org.example.p04bean.Cloth;
import org.example.p04bean.PageBean;

import java.util.List;
import java.util.Scanner;

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
        stringBuilder.append("0").append(" ").append("搜索页面");
        System.out.println(stringBuilder.toString());

    }

    public int getBid() {
        System.out.println("请输入您想要查看的汉服品牌的代码id：");
        Scanner scanner = new Scanner(System.in);
        int num=scanner.nextInt();
        return num;
    }

    public void showCloth(List<Cloth> clothlist) {
        //创建StringBuilder构造器
        StringBuilder stringBuilder=new StringBuilder();
        //依次打印相应tab_brand中bid对应的tab_cloth的每一行
        for (int i=0;i<clothlist.size();i++){
            Cloth cloth=clothlist.get(i);
            stringBuilder.append(cloth.getHname()).append("\n");
            stringBuilder.append(cloth.gethIntroduce()).append("\n");
            stringBuilder.append(cloth.getHprice()).append("¥ ||");
        }

        System.out.println(stringBuilder.toString());

    }



    public int getCurrentPage(PageBean<Cloth> pageBean) {
        System.out.println("【当前是第"+pageBean.getCurrentPage()+"页，共"+pageBean.getTotalPage()+"页】\n可以输入页号：1到"+pageBean.getTotalPage()+"页的数字查看分页，其他数字退回分类页面");
        System.out.println("请输入您想要浏览的页：(不在页数范围内的数字都将跳转到品牌分类页面)");
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        return num;
    }
    public void showPageBean(PageBean<Cloth> pageBean) {
        clear();
        System.out.println("======================这里是汉服详情页面=========================");
        showCloth(pageBean.getList());
    }
}
