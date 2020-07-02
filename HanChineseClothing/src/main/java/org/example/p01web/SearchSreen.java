package org.example.p01web;

import org.example.p04bean.Cloth;
import org.example.p04bean.PageBean;

import java.util.List;
import java.util.Scanner;

public class SearchSreen extends BaseScreen{
    public void show() {
        clear();
        System.out.println("==================================这里是汉服搜索页面==========================================");
        System.out.println("您可以根据您感兴趣的汉服形制进行搜索，有且不限于：齐腰、齐胸、圆领袍、大袖衫等");
        System.out.println("您也可以根据您喜欢的朝代来搜索，有且不限于：唐、宋、明、魏晋等");
    }

    public String getKeyword() {
        System.out.println("请输入您需要搜索的关键词：");
        Scanner scanner = new Scanner(System.in);
        String keyword=scanner.nextLine().trim();
        return keyword;
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

    public void showPageBean(PageBean<Cloth> pageBean) {
        clear();
        //显示记录
        showCloth(pageBean.getList());
        System.out.println("搜索结果"+pageBean.getTotalCount()+"条记录，分为"+pageBean.getTotalPage()+"页，当前是第"+pageBean.getCurrentPage()+"页");
    }

    public int getCurrentPage() {
        System.out.println("请输入搜索结果中需要查看的页面：在存在的页数之间");
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        return num;
    }
}
