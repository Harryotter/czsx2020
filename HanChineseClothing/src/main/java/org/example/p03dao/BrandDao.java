package org.example.p03dao;


import org.example.p04bean.Brand;
import org.example.util.JdbcTemplateUtil;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BrandDao {
    private RowMapper<Brand> mapper=new RowMapper<Brand>() {
        @Override
        public Brand mapRow(ResultSet resultSet, int i) throws SQLException {
            //创建一个Brand对象
            Brand brand=new Brand();
            //给对象中的每一个成员赋值上数据库的记录
            brand.setBid(resultSet.getLong("bid"));
            brand.setBname(resultSet.getString("bname"));
            //返回一个Brand对象
            return brand;
        }
    };

    public List<Brand> findAll() throws Exception {
        //sql语句
        String sql="SELECT * FROM tab_brand ORDER BY bid";
        //执行SQL查询
        /**
         * mapper 是转换器：用来把一行数据转换成一个对象
         */
        List<Brand> list=JdbcTemplateUtil.getJdbcTemplate().query(sql,mapper,new Object[]{});
        //返回列表
        return list;
    }
}
