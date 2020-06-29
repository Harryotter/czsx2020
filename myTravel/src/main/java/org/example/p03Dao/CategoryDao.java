package org.example.p03Dao;

import org.example.bean.Category;
import org.example.util.JdbcTemplateUtil;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//读写数据库的旅游分类的数据
public class CategoryDao {
    //把一行数据转换成一个对象
    private RowMapper<Category> mapper=new RowMapper<Category>() {

        //每一行都执行一遍
        @Override
        public Category mapRow(ResultSet resultSet, int i) throws SQLException {
            //创建一个对象
            Category category=new Category();
            //给每一行赋值(转化)
            category.setCid(resultSet.getLong("cid"));
            category.setCname(resultSet.getString("cname"));
            return category;
        }
    };

    public List<Category> findAll() throws Exception {
        //查询
        String sql=("SELECT * FROM tab_category ORDER BY cid");
        //执行sql
        List<Category> list=JdbcTemplateUtil.getJdbcTemplate().query(sql,mapper,new Object[]{});//参一：sql，参二：转换器，参三：参数值
        //返回
        return list;
    }
}
