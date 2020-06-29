package org.example.p03Dao;

import org.example.bean.Route;
import org.example.util.JdbcTemplateUtil;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RouteDao {
    //转换器：将一个列表对象转换成java对象
    RowMapper<Route> mapper=new RowMapper<Route>() {
        @Override
        public Route mapRow(ResultSet resultSet, int i) throws SQLException {
            //创建一个route对象
            Route route=new Route();
            //给成员变量赋值
            route.setRid(resultSet.getLong("rid"));
            route.setRname(resultSet.getString("rname"));
            route.setIntroduce(resultSet.getString("routeIntroduce"));
            route.setPrice(resultSet.getDouble("price"));
            route.setRdate(resultSet.getString("rdate"));
            return route;//返回查询对象
        }
    };
    public List<Route> FindById(Integer cid) throws Exception {
        //sql
        String sql="SELECT * FROM tab_route where cid=?";
        //执行sql
        List<Route> list=JdbcTemplateUtil.getJdbcTemplate().query(sql,mapper,cid);//参一：sql 参二：转换器 参三：参数值
        //返回
        return list;

    }
}
