package com.itheima.jdbc.druid.druid;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;
import com.alibaba.druid.pool.DruidDataSourceFactory;
public class Druiddemo {
    public static void main(String[] args) throws Exception {
        //1.导包

        //2.定义配置文件

        //3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));
        //4.获取连接池对象
       DataSource dataSource= DruidDataSourceFactory.createDataSource(prop);
       //5.获取数据库链接
       Connection conn = dataSource.getConnection();
        System.out.println(conn);
    }
}
