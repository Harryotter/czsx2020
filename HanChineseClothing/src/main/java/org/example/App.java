package org.example;

import org.example.p01web.BrandScreen;
import org.example.p01web.UserRegisterScreen;
import org.example.p01web.MyScreen;
import org.example.p02service.BrandService;
import org.example.p02service.ClothService;
import org.example.p02service.UserService;
import org.example.p04bean.Brand;
import org.example.p04bean.Cloth;
import org.example.p04bean.PageBean;
import org.example.p04bean.User;

import java.util.List;

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
    public static void main( String[] args ) throws Exception {
        //创建一个品牌分类界面并且显示
        BrandScreen brandScreen=new BrandScreen();
        brandScreen.show();
        //获取数据显示在品牌分类界面
        BrandService brandService=new BrandService();
        List<Brand> list=brandService.findAll();
        //显示
        brandScreen.show(list);

        //输入一个品牌代表id，显示该品牌旗下的汉服服装
        int bid=brandScreen.getBid();
        //调用汉服服装类的业务方法查询该品牌下的汉服
        ClothService clothService = new ClothService();
        //使用分页业务逻辑
        int pageSize=3;
        int currpage=-1;
        PageBean<Cloth> pageBean=null;
        while(true){
            if(currpage==-1){
                currpage=1;
                pageBean=clothService.queryByPage(bid,pageSize,currpage);
                //显示
                brandScreen.showPageBean(pageBean);
            }
            //让用户选择显示那个页面
            currpage=brandScreen.getCurrentPage(pageBean);
            //输入合法的情况下
            if(currpage>=1 && currpage <=pageBean.getTotalPage()){
                pageBean=clothService.queryByPage(bid,pageSize,currpage);
                //显示
                brandScreen.showPageBean(pageBean);
            }
            //非法显示
            else{
//这里跳转到品牌分类页面    toCategoryPage();
                break;
            }
        }


    }

    public static void main4(String[] args) {

    }
}
