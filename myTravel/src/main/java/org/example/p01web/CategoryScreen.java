package org.example.p01web;

import org.example.bean.Category;
import org.example.bean.Route;

import java.util.List;
import java.util.Scanner;

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

        public int getCid(){
        System.out.println("请输入分类的整数id");
            Scanner scanner = new Scanner(System.in);
            //读一个整数
            int i=scanner.nextInt();
            //
            return i;


        }


    public void showRoutes(List<Route> routeList) {
        System.out.println("================这里是国内路线介绍===================");
        StringBuilder stringBuilder=new StringBuilder();

        for(int i=0;i<routeList.size();i++){
            Route route=routeList.get(i);
            //stringBuilder拼接字符串
            stringBuilder.append(route.getRname()).append("\n");
            stringBuilder.append(route.getRid()).append("|");
            stringBuilder.append(route.getPrice()).append("¥| ");
            stringBuilder.append(route.getRdate()).append("\n");
            stringBuilder.append(route.getIntroduce()).append("\n");

            stringBuilder.append("=============================================\n");

        }
        System.out.println(stringBuilder.toString());
    }
}
