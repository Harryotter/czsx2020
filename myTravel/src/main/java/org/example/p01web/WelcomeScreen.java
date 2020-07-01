package org.example.p01web;

import java.util.Scanner;

public class WelcomeScreen extends BaseScreen{
    public void loading() throws InterruptedException {
        //1% 100%
        clear();
        for(int i=1;i<=100;i++){
            Thread.sleep(5);
            clear();
            System.out.println("系统加载中"+i+"%");
        }

    }

    public void show() {
        clear();
        System.out.println("=====================================这里是欢迎界面==================================");
        System.out.println("1：注册 2：登录 3:分类页面 4：搜索 ");
        System.out.println("其他数字退出程序");
        System.out.println("请输入需要进入的页面的数字：");

    }

    public int getNum() {

        Scanner scanner = new Scanner(System.in);
        int num=scanner.nextInt();
        return num;
    }


}
