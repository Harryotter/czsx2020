package org.example.service;


import org.example.bean.Category;
import org.example.bean.Route;
import org.example.p02service.CategoryService;
import org.example.p02service.RouteService;
import org.junit.Test;
import org.springframework.util.RouteMatcher;

import java.util.List;


public class RouteServiceTest {
    @Test
    public void test01FindById() throws Exception {
        //创建线路的业务对象
        RouteService routeService=new RouteService();
        //传一个分类cid
        Integer cid=5;
        List<Route> list=routeService.findRoutesByCid(cid);
        //查找获得结果
        System.out.println(list);

    }

}
