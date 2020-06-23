package org.example.Dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidTest {
    @Test
    public void test01Druid() throws Exception {
        //获取连接
        Connection connection=getConnection();
        //打印
        System.out.println(connection);
    }

    private Connection getConnection() throws Exception {
        //1.读配置文件
        InputStream inputStream=DruidTest.class.getResourceAsStream("/druid.properties");
        Properties properties=new Properties();
        properties.load(inputStream);
        System.out.println(properties.getProperty("druid.username"));
        //2.设置Druid对象
        DruidDataSource source= (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);

        //3.取连接
        return source.getConnection();
    }
}
