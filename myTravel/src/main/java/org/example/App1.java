package org.example;

import org.example.p04bean.Category;
import org.example.p04bean.PageBean;
import org.example.p04bean.Route;
import org.example.p04bean.User;
import org.example.p01web.CategoryScreen;
import org.example.p01web.MyScreen;
import org.example.p01web.SearchScreen;
import org.example.p01web.UserRegisterScreen;
import org.example.p02service.CategoryService;
import org.example.p02service.RouteService;
import org.example.p02service.UserService;

import java.util.List;

import static org.example.Demo1.clear;

/**
 * Hello world!
 *
 */
public class App1
{
    public static void main1( String[] args ) {
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



    }
    public static void main3(String[] args ) throws Exception {
        categoryLogic();
    }
    public static void categoryLogic() throws Exception {
        //显示界面
        CategoryScreen categoryScreen=new CategoryScreen();
        categoryScreen.show();
        //调用业务逻辑层的方法获取数据
        CategoryService categoryService=new CategoryService();
        List<Category> list = categoryService.findAll();
        categoryScreen.show(list);

        //输入整数cid，显示该分类下的路线信息
        int cid=categoryScreen.getCid();
        //调用业务逻辑层中业务方法获取该分类下的路线信息
        RouteService routeService=new RouteService();
//        List<Route> routeList=routeService.findRoutesByCid(cid);
        //使用分页业务逻辑
        int pageSize=10;
        int currpage=-1;
        PageBean<Route> pageBean=null;
        while(true){
            if(currpage==-1){
                currpage=1;
                pageBean=routeService.queryByPage(cid,pageSize,currpage);
                //显示
                categoryScreen.showPageBean(pageBean);
            }
            //让用户选择显示那个页面
            currpage=categoryScreen.getCurrentPage(pageBean);
            //输入合法的情况下
            if(currpage>=1 && currpage <=pageBean.getTotalPage()){
                pageBean=routeService.queryByPage(cid,pageSize,currpage);
                //显示
                categoryScreen.showPageBean(pageBean);
            }
            //非法显示
            else{
                categoryLogic();
                break;
            }
        }




//        categoryScreen.showRoutes(routeList);
    }
    public static  void main(String args[]) throws Exception {
        SearchScreen searchScreen = new SearchScreen();

        searchScreen.show();
        String keyword=searchScreen.getKeyWord();

        int currentPage=-1;
        int pageSize=10;
        PageBean<Route> pageBean = null;
        //
        //
        RouteService routeService = new RouteService();
        while(true){
            if(currentPage==-1) {
                currentPage = 1;
                pageBean = routeService.search(keyword, pageSize, currentPage);
                searchScreen.showPageBean(pageBean);
            }
            currentPage=searchScreen.getCurrentPage();

            if(currentPage>=1 && currentPage<=pageBean.getTotalPage()){
                 pageBean = routeService.search(keyword, pageSize, currentPage);
                 searchScreen.showPageBean(pageBean);
            }
            else{
                    break;
                }



        }


    }
}
