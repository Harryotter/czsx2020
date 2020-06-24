package org.example.p01web;

import org.example.bean.User;

import java.util.Scanner;

public class MyScreen {
    //清屏
    public static void clear(){
        try{
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();

        }catch (Exception e){

        }
    }
    public void showLogin() {
        clear();
        System.out.println("===========欢迎来到，登录界面！！！===========");

    }
    //获取用户输入的数据

    public User getData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username=scanner.nextLine().trim();
        System.out.println("请输入密码：");
        String password=scanner.nextLine().trim();
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }

    public void showResult(int num) {
        if (num==1){
            System.out.println("登录成功！！！");
        }
        else{
            System.out.println("登录失败！！！");
        }
    }



}
