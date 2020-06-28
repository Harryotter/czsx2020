package org.example.p01web;

import org.example.bean.User;

import java.util.Scanner;

import static org.example.p01web.MyScreen.clear;

public class UserRegisterScreen extends BaseScreen{


    public void show() {
        clear();
        System.out.println("==========欢迎来到注册界面=========");
    }

    public User getData() {
        //创建一个用户实体类
        User user=new User();
        //输入用户
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入用户名：");
        user.setUsername(scanner.nextLine().trim());
        System.out.println("请输入用户密码：");
        user.setPassword(scanner.nextLine().trim());
        System.out.println("请输入姓名：");
        user.setName(scanner.nextLine().trim());
        System.out.println("请输入生日如：1999-06-01");
        user.setBirthday(scanner.nextLine().trim());
        System.out.println("请输入性别：男/女：");
        user.setSex(scanner.nextLine().trim());
        System.out.println("请输入电话：");
        user.setTelephone(scanner.nextLine().trim());
        System.out.println("请输入邮件：");
        user.setEmail(scanner.nextLine().trim());

        return user;

    }

    public void showResult(int code) {
        if(1==code){
            System.out.println("恭喜您,注册成功！！！");
        }
        else if(-1==code){
            System.out.println("您注册的用户已经存在，请重新注册");
        }
    }
}
