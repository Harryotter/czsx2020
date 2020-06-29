package org.example.p02service;

import org.example.bean.Route;
import org.example.p03Dao.RouteDao;

import java.util.List;

public class RouteService {

    public List<Route> findRoutesByCid(Integer cid) throws Exception {
        //创建dao
        RouteDao routeDao=new RouteDao();
        //业务层调dao层
        List<Route> list=routeDao.FindById(cid);
        //返回list
        return list;

    }


}
