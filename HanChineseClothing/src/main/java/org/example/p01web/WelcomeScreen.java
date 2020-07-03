package org.example.p01web;

import java.util.Scanner;

public class WelcomeScreen extends BaseScreen{
    public void loading() throws InterruptedException {
        //1% 100%
        clear();
        for(int i=1;i<=100;i++){
            Thread.sleep(2);
            clear();
            System.out.println("系统加载中____#*@_@*^_^*#_____"+i+"%______#*@_@*^_^*#____");
        }
    }
    public void show() {
        clear();
        System.out.println("===❀====❀====❀====❀========❀❀❀岂曰无衣，与子同袍❀❀❀======❀=====❀======❀=====❀=====❀===");
        System.out.println("=====❀====❀====❀========❀❀❀欢迎来到，汉服文化及品牌推广网❀❀❀======❀======❀=====❀=====❀=====");
        System.out.println("❀温馨提示：亲爱的用户，为您提供页面跳转id：❀  ");
        System.out.println("1：注册界面 2：登录界面 3:汉服品牌分类页面 4：搜索其他数字退出程序");
        System.out.println("请您输入需要进入的页面的数字：");
    }
    public int getNum() {
        Scanner scanner = new Scanner(System.in);
        int num=scanner.nextInt();
        return num;
    }
}
