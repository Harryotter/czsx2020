package org.example.service;


import org.example.p04bean.PageBean;
import org.example.p04bean.Route;
import org.example.p02service.RouteService;
import org.junit.Test;


public class SearchServiceTest {
    @Test
    public void test01FindByCid() throws Exception {
        //创建线路的业务对象
        RouteService routeService=new RouteService();
        //调用搜索方法
        PageBean<Route> pageBean = routeService.search("广州",20,1);
        //打印
        System.out.println(pageBean);

    }


}
