package org.example.p03Dao;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class UserDao {
//    public void save(){
//        System.out.println("保存");
//    }
//    public void update(){
//        int a=12;
//        int b=2;
//        System.out.println("更新");
//        System.out.println(a/b);
//    }
//    public void delete(){
//        System.out.println("删除");
//    }
//    public void find(){
//        System.out.println("查找");
//    }

    public int findByUsernamePassword(String username, String password) throws Exception {
        //查询数据库
        //1.编写sql
        String sql="SELECT count(*) FROM tab_user WHERE username=? AND password=?";
        //2.用query执行查询
        //配置数据连接池、druid

        //数据源
        DataSource dataSource=getDruidDataSource();
        //模板对象
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        //用户名、密码放在一个数组中
        Object[] args=new Object[]{username,password};
        Integer count=jdbcTemplate.queryForObject(sql,args,Integer.class);
        return count;

    }
    private static DataSource dataSource=null;
    //获取数据连接池
    private DataSource getDruidDataSource() throws Exception, SQLException {
        //用一个静态来优化数据源
        if (dataSource==null)
        {
            //1.读配置文件
            InputStream inputStream=UserDao.class.getResourceAsStream("/druid.properties");
            Properties properties=new Properties();
            properties.load(inputStream);
            //2.设置Druid对象
            dataSource= (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);


        }

         return dataSource;

    }
}
