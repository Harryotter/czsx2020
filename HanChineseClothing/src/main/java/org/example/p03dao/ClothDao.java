package org.example.p03dao;

import org.example.p04bean.Brand;
import org.example.p04bean.Cloth;
import org.example.util.JdbcTemplateUtil;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClothDao {
    private RowMapper<Cloth> mapper=new RowMapper<Cloth>() {
        @Override
        public Cloth mapRow(ResultSet resultSet, int i) throws SQLException {
            //创建一个Cloth对象
            Cloth cloth=new Cloth();
            //给对象中的每一个成员赋值上数据库的记录
            cloth.setHid(resultSet.getLong("hid"));
            cloth.setHname(resultSet.getString("hname"));
            cloth.sethIntroduce(resultSet.getString("hIntroduce"));
            cloth.setHprice(resultSet.getDouble("hprice"));
            //返回一个Cloth对象
            return cloth;
        }
    };

    public List<Cloth> findByBid(int bid) throws Exception {
        //sql语句
        String sql="SELECT * FROM tab_cloth where bid=?";
        //执行
        List<Cloth> list=JdbcTemplateUtil.getJdbcTemplate().query(sql,mapper,bid);
        //返回列表
        return list;
    }

    public int findCount(int bid) throws Exception {
        //sql
        String sql="SELECT COUNT(*) FROM tab_cloth WHERE bid=?";
        //执行
        Integer count = JdbcTemplateUtil.getJdbcTemplate().queryForObject(sql, new Object[]{bid}, Integer.class);
        return count;
    }

    public List<Cloth> findPage(int bid, int pageSize, int currentPage) throws Exception {
        /**
         * 查找公式
         */
        //获取起始的页
        int start=(currentPage-1)*pageSize;
        int num=pageSize;
        //sql 注意limit上限的用法
        String sql="SELECT * FROM tab_cloth WHERE bid=? LIMIT ?,?;";
        //执行
        List<Cloth> list=JdbcTemplateUtil.getJdbcTemplate().query(sql,new Object[]{bid,start,num},mapper);
        return list;
    }
}
