package org.example.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.example.p03dao.UserDao;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

//数据源与模板对象的工具类
public class JdbcTemplateUtil {
    /**
     * 获取模板对象
     * @return
     * @throws Exception
     */
    public static JdbcTemplate getJdbcTemplate() throws Exception {
        //获取数据源
        DataSource dataSource=getDruidDataSource();
        //创建模板对象
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        //设置数据源
        jdbcTemplate.setDataSource(dataSource);
        //返回模板
        return jdbcTemplate;
    }
    private static DataSource dataSource=null;
    //获取数据连接池
    private static DataSource getDruidDataSource() throws Exception, SQLException {
        /**
         * 获取数据源对象
         */
        //用一个静态来优化数据源
        if (dataSource==null)
        {
            //1.读配置文件
            InputStream inputStream= UserDao.class.getResourceAsStream("/druid.properties");
            Properties properties=new Properties();
            properties.load(inputStream);
            //2.设置Druid对象
            dataSource= (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);


        }

        return dataSource;

    }
}
