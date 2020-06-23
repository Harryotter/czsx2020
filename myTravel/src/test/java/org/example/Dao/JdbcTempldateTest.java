package org.example.Dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcTempldateTest {
    @Test
    public void test01Druid() throws Exception {
        //1.创建JdbcTemplate模板对象
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        //2.设置druid
        jdbcTemplate.setDataSource(getDruidDataSource());
        //3.调用update,query
        jdbcTemplate.update("delete from tab_user where uid=?",1);
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
