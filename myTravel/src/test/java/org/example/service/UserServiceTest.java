package org.example.service;

import org.example.p04bean.User;
import org.example.p02service.UserService;
import org.junit.Test;


public class UserServiceTest {
    @Test
    public void test01Login() throws Exception {
        //1.创建一个业务类
        UserService userService=new UserService();
        //2.调用登录方法
        User user=new User();
        user.setUsername("芦荟妹子");
        user.setPassword("123");
        //3.判断结果
        int result=userService.login(user);
        if (result==1)
        {
            System.out.println("登录成功！！！");

        }
        else{
            System.out.println("登录失败！！！");

        }
    }
    @Test
    public void test02Register() throws Exception{
        //模拟一个用户
        User user=new User();
        user.setUsername("包子wang");
        user.setPassword("123");
        user.setEmail("123123123@");
        user.setName("王包");

        //调用业务方法
        UserService userService=new UserService();
        int code=userService.register(user);
        //返回值
        if(1==code){
            System.out.println("Success");
        }
        else if(-1==code){
            System.out.println("Fail");
        }
    }
}
