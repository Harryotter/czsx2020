package org.example.Dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.example.bean.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.server.RMIClassLoader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcTempldateTest {
    //定义一个成员变量，被所有方法访问
    //类名 对象名
    JdbcTemplate jdbcTemplate=null;
    @Before
    public void init() throws Exception {
        System.out.println("-----这里是：init--------");
        //1.创建JdbcTemplate模板
        jdbcTemplate=new JdbcTemplate();
        //2.设置druid
        jdbcTemplate.setDataSource(getDruidDataSource());

    }
    @Test
    public void test01Druid() throws Exception {
//        //1.创建JdbcTemplate模板对象
//        JdbcTemplate jdbcTemplate=new JdbcTemplate();
//        //2.设置druid
//        jdbcTemplate.setDataSource(getDruidDataSource());
        //3.调用update,query
        jdbcTemplate.update("delete from tab_user where uid=?",1);
    }
    //数据插入
    @Test
    public void test02Insert(){
        //一参：sql 二参：数值
        jdbcTemplate.update("insert into tab_user(uid,username,password,name,birthday,sex,telephone,email,status,code)VALUES(?,?,?,?,?,?,?,?,?,?)",3,"章鱼","123","秀秀","1999-03-06","男","123123","123123@","3","2018233534");
        System.out.println("------test02Insert success!!!-------");
    }
    //数据修改
    @Test
    public void test03Update(){
        //一参：sql 二参：数值
        jdbcTemplate.update("update tab_user SET username=?WHERE uid=?","芦荟妹子",2);
        System.out.println("------test03Update success!!!-------");
    }
    //数据查询
    @Test
    public void test04Select(){
        //1.sql语句查询
        String sql="SELECT * FROM tab_user where uid=?";
        //2.实体类的一个对象的成员变量保存打印数据
        //3.调用query执行查询
        //用mapper结果集表示查询结果
        RowMapper<User> mapper=new RowMapper<User>(){

            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user=new User();//new一个实体类对象
                user.setUid(resultSet.getLong("uid"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setBirthday(resultSet.getString("birthday"));
                user.setSex(resultSet.getString("sex"));
                user.setTelephone(resultSet.getString("telephone"));
                user.setEmail(resultSet.getString("email"));
                user.setStatus(resultSet.getString("status"));
                user.setCode(resultSet.getString("code"));
                return user;//返回new的实体类对象
            }
        };
        //参一：sql参二：转换规则参三：数值（uid）
        User user=jdbcTemplate.queryForObject(sql,mapper,3);
        System.out.println(user);
        System.out.println("------test04Select success!!!-------");
    }



    //获取数据连接池
    private DataSource getDruidDataSource() throws Exception, SQLException {
        //1.读配置文件
        InputStream inputStream=DruidTest.class.getResourceAsStream("/druid.properties");
        Properties properties=new Properties();
        properties.load(inputStream);
        System.out.println(properties.getProperty("druid.username"));

        //2.设置Druid对象
        DruidDataSource source= (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

        return source;

    }
}
