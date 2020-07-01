package org.example.p01web;

import org.example.p04bean.PageBean;
import org.example.p04bean.Route;

import java.util.List;
import java.util.Scanner;

public class SearchScreen extends BaseScreen{
    public void show() {
        clear();
        System.out.println("============================这里是搜索页面==========================");
    }

    public String getKeyWord() {
        System.out.println("请输入关键词");
        Scanner scanner = new Scanner(System.in);
        String keyword=scanner.nextLine().trim();
        return keyword;
    }
    public void showRoutes(List<Route> routeList){

        StringBuilder stringBuilder=new StringBuilder();

        for(int i=0;i<routeList.size();i++){
            Route route=routeList.get(i);
            //stringBuilder拼接字符串
            stringBuilder.append(route.getRname()).append("\n");
            stringBuilder.append(route.getRid()).append("|");
            stringBuilder.append(route.getPrice()).append("¥ |");
            stringBuilder.append(route.getRdate()).append("\n");
            stringBuilder.append(route.getIntroduce()).append("\n");

            stringBuilder.append("=============================================\n");

        }
        System.out.println(stringBuilder.toString());
    }

    public void showPageBean(PageBean<Route> pageBean) {
        clear();
        //显示记录
        showRoutes(pageBean.getList());
        System.out.println("搜索结果"+pageBean.getTotalCount()+"条记录，分为"+pageBean.getTotalPage()+"页，当前是第"+pageBean.getCurrentPage()+"页");
    }

    public int getCurrentPage() {

        System.out.println("请输入需要查看的页面：在1~5之间");
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        return num;
    }
}
