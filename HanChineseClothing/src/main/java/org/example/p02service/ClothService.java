package org.example.p02service;

import org.example.p03dao.ClothDao;
import org.example.p04bean.Cloth;
import org.example.p04bean.PageBean;

import java.util.List;

public class ClothService {

    public List<Cloth> findClothByBid(int bid) throws Exception {
        //创建Dao层的一个对象类
        ClothDao clothDao = new ClothDao();
        //调用Dao层的查询方法
        List<Cloth> list=clothDao.findByBid(bid);
        //返回列表
        return list;
    }

    public PageBean<Cloth> queryByPage(int bid, int pageSize, int currentPage) throws Exception {
        //创建分页对象
        PageBean<Cloth> pageBean=new PageBean<Cloth>();
        //设置每页的记录数  1
        pageBean.setPageSize(pageSize);
        //当前所在页  2
        pageBean.setCurrentPage(currentPage);
/**
 * PageBean中的其他成员对象通过Dao查询：
 * 总记录数、tab_cloth中的总共记录条数、分割后的页数
 */
        //创建Dao对象
        ClothDao clothDao = new ClothDao();
        //查询总记录数  3
        int count=clothDao.findCount(bid);
        pageBean.setTotalCount(count);
        //计算所分割后的页数  4

        int totalPage;
        //判断页数能否整除
        if(count%pageSize==0)
            totalPage =count/pageSize;
        else{
            totalPage=count/pageSize+1;
        }
        pageBean.setTotalPage(totalPage);
        //设置当前页的集合（列表）  5
        List<Cloth> pagebean=clothDao.findPage(bid,pageSize,currentPage);
        pageBean.setList(pagebean);
        return pageBean;


    }

    public PageBean<Cloth> search(String keyword,int pageSize,int currentPage) throws Exception {
     //创建分页对象
        PageBean<Cloth> pageBean=new PageBean<Cloth>();
        //设置每页记录数  1
        pageBean.setPageSize(pageSize);
        //当前所在页  2
        pageBean.setCurrentPage(currentPage);
/**
* PageBean中的其他成员对象通过Dao查询：
* 总记录数、tab_cloth中的总共记录条数、分割后的页数
*/
    //创建Dao对象
        ClothDao clothDao = new ClothDao();
        //查询总记录数  3
        int count=clothDao.findCountByKeyword(keyword);
        pageBean.setTotalCount(count);
        //计算所分割后的页面  4
        int totalpage;
        if(count%pageSize==0){
            totalpage=count/pageSize;
        }else{
            totalpage=count/pageSize+1;
        }
        pageBean.setTotalPage(totalpage);

        //设置当前页面的集合  5
        List<Cloth> list=clothDao.findPageByKeyword(keyword,pageSize,currentPage);
        pageBean.setList(list);
    //返回分页对象
        return pageBean;

    }
}
