package org.example;

import org.example.p01web.UserRegisterScreen;
import org.example.p01web.MyScreen;
import org.example.p02service.UserService;
import org.example.p04bean.User;

import static org.example.p01web.BaseScreen.clear;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main1( String[] args ){
        for(int i=0;i<3;i++){
            //1.显示登陆界面
            MyScreen myScreen = new MyScreen();
            myScreen.showLogin();
            //2.获取界面输入的数据
            //获取用户输入的数据
            User user=myScreen.getData();
            //调用登录的业务方法
            UserService userService=new UserService();
            try {
                int  num = userService.login(user);
                //根据业务方法返回结果来显示成功界面或者失败界面
                myScreen.showResult(num);
                if(num!=0){
                    //登录成功,打开分类页面
// 这里是商家分类页面   toCategoryPage();
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }




    }
    public static void main2( String[] args ) throws Exception {
        clear();
        //显示界面
        UserRegisterScreen userRegisterScreen=new UserRegisterScreen();
        userRegisterScreen.show();
        //显示数据
        //获取数据
        User user=userRegisterScreen.getData();
        //调用register方法
        UserService userService=new UserService();
        int code=userService.register(user);
        userRegisterScreen.showResult(code);
//        //注册成功，打开登录界面
//        if(code==1){
//            toLoginPage();
//        }
//        else{
//            toRegisterPage();
//        }

    }
    public static void main5( String[] args )
    {

//        System.out.println( "Hello World!" );
    }
}
