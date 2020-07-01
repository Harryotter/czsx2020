package org.example.service;


import org.example.p04bean.PageBean;
import org.example.p04bean.Route;
import org.example.p02service.RouteService;
import org.junit.Test;

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
    @Test
    public void test02FindByCid() throws Exception {
        //创建线路的业务对象
        RouteService routeService=new RouteService();
        //传一个分类cid
        Integer cid=5;
        PageBean<Route> pageBean=routeService.queryByPage(cid,20,3);//要查询的页数//当前
        //查找获得结果
        System.out.println(pageBean);

    }

}
