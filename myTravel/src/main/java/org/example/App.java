package org.example;

import org.example.bean.User;
import org.example.p01web.MyScreen;
import org.example.p02service.UserService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
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
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }
}
