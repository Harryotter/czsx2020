package org.example.p02service;

import org.example.p04bean.PageBean;
import org.example.p04bean.Route;
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

//参数：分类id、每页的记录数、当前页
    public PageBean<Route> queryByPage(Integer cid, int pageSize, int currentPage) throws Exception {
        //创建分页数
        PageBean<Route> pageBean=new PageBean<>();
        //每页记录数
        pageBean.setPageSize(pageSize);
        //当前是第几页
        pageBean.setCurrentPage(currentPage);
        //其他数据通过dao查询
        RouteDao routeDao=new RouteDao();

        //查询总记录数（查询数据库）
        int count =routeDao.findCount(cid);
        pageBean.setTotalCount(count);

        //页数 （20）
        int page=0;
        //判断页数能否整除
        if(count%pageSize==0)
           page =count/pageSize;
        else{
            page=count/pageSize+1;
        }
        pageBean.setTotalPage(page);

        //当前页集合（查询数据库）
        List<Route> list=RouteDao.findPage(cid,pageSize,currentPage);
        pageBean.setList(list);

        return pageBean;
    }
//搜索词、每页记录数、当前第几页
    public PageBean<Route> search(String keyword, int pageSize, int currentPage) throws Exception {
    PageBean<Route> pageBean=new PageBean<Route>();
    //成员变量
        pageBean.setPageSize(pageSize); //1
        pageBean.setCurrentPage(currentPage);//2
        //调用Dao
        RouteDao routeDao=new RouteDao();
        int count=routeDao.findCountByKeyWord(keyword);
        pageBean.setTotalCount(count);//3

        //页数 （20）
        int totalPage;
        //判断页数能否整除
        if(count%pageSize==0)
            totalPage =count/pageSize;
        else{
            totalPage=count/pageSize+1;
        }
        pageBean.setTotalPage(totalPage);//4
        //最后一个list
        List<Route> list = routeDao.findPageByKeyWord(keyword,pageSize,currentPage);//5
        pageBean.setList(list);
        return pageBean;
        //主函数在哪
    }
}
