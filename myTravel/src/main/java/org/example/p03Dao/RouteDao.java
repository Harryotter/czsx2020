package org.example.p03Dao;

import org.example.p04bean.Route;
import org.example.util.JdbcTemplateUtil;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RouteDao {
    //转换器：将一个列表对象转换成java对象
    static RowMapper<Route> mapper=new RowMapper<Route>() {
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

    public int findCount(Integer cid) throws Exception {
        String sql="SELECT COUNT(*) FROM tab_route WHERE cid=?";
        int count = JdbcTemplateUtil.getJdbcTemplate().queryForObject(sql, new Object[]{cid}, Integer.class);
        return count;
    }
    //查询指定范围的分页
    public static List<Route> findPage(Integer cid, int pageSize, int currentPage) throws Exception {
        //查找公式
        int start=(currentPage-1)*pageSize;
        int num=pageSize;
        //limit
        String sql="SELECT * FROM tab_route WHERE cid= ? LIMIT ?,?";
        List<Route> list=JdbcTemplateUtil.getJdbcTemplate().query(sql,new Object[]{cid,start,num},mapper);
        return list;

    }



    public int findCountByKeyWord(String keyword) throws Exception {
        String sql="SELECT count(*)FROM tab_route WHERE rname LIKE ?";
        int count=JdbcTemplateUtil.getJdbcTemplate().queryForObject(sql,new Object[]{"%"+keyword+"%"},Integer.class);

        return count;
    }
    public List<Route> findPageByKeyWord(String keyword, int pageSize, int currentPage) throws Exception {
        String sql="SELECT * FROM tab_route WHERE rname LIKE ? limit ?,?";
        int start=(currentPage-1)*pageSize;

        // List<Route> list=JdbcTemplateUtil.getJdbcTemplate().query(sql,new Object[]{keyword,start,pageSize},mapper);
        List<Route> list = JdbcTemplateUtil.getJdbcTemplate().query(sql, new Object[]{"%"+keyword+"%", start, pageSize}, mapper);
        return list;



    }
}
