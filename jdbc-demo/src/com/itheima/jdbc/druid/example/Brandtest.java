package com.itheima.jdbc.druid.example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.itheima.jdbc.druid.pojo.Brand;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/*
品牌数据的增删改查
 */
public class Brandtest {
    /*
    查询所有
     */
    @Test
    public void testSlectAll() throws Exception {
        //1.获取连接对象
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));

        DataSource dataSource= DruidDataSourceFactory.createDataSource(prop);

        Connection conn = dataSource.getConnection();
        //2.定义sql
        String sql = "select * from tb_brand";

        //3.获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //4.设置参数

        //5.执行sql
        ResultSet rs = pstmt.executeQuery();

        //6.处理结果list<Brand>封装Brand对象，装载List集合
        Brand brand=null;
        List<Brand> brands=new ArrayList<>();
        while (rs.next()) {
            //获取数据
            int id =rs.getInt("id");
            String brandName=rs.getString("brand_name");
            String companyName=rs.getString("company_name");
            int ordered=rs.getInt("ordered");
            String description=rs.getString("description");
            int status=rs.getInt("status");

            //封装Brand对象
            brand=new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setDescription(description);
            brand.setStatus(status);
            brand.setCompany_name(companyName);
            brand.setOrdered(ordered);

            //装载集合
            brands.add(brand);
        }
        //7.释放资源
        pstmt.close();
        conn.close();
        rs.close();
    }


    /*
    添加
    1.sql：insert into tb_brand(brand_name, company_name, ordered, description, status) values(?,?,?,?,?);
    2.参数：需要，除了id以外的所有参数信息
    3.结果：布尔类型
     */
    @Test
    public void testAdd() throws Exception {
        // 接收页面提交的参数
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1;
        String description = "绕地球一圈";
        int status = 1;

        //1.获取连接对象
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));

        DataSource dataSource= DruidDataSourceFactory.createDataSource(prop);

        Connection conn = dataSource.getConnection();
        //2.定义sql
        String sql = "insert into tb_brand(brand_name, company_name, ordered, description, status) values(?,?,?,?,?)";

        //3.获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //4.设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);
        //5.执行sql
        int count = pstmt.executeUpdate();//影响的行数

        //6.输出结果
        System.out.println(count > 0);

        //7.释放资源
        pstmt.close();
        conn.close();
   }

    /*
     修改
     1.sql：
     update tb_brand
         set brand_name  = ?,
         company_name= ?,
         ordered     = ?,
         description = ?,
         status      = ?
     where id = ?
     2.参数：需要，所有数据
     3.结果：布尔类型
      */
    @Test
    public void testUpdateById() throws Exception {
        // 接收页面提交的参数
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 999;
        String description = "绕地球三圈";
        int status = 1;
        int id = 4;

        //1.获取连接对象
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));

        DataSource dataSource= DruidDataSourceFactory.createDataSource(prop);

        Connection conn = dataSource.getConnection();
        //2.定义sql
        String sql = "update tb_brand" +
                "         set brand_name  = ?," +
                "         company_name= ?," +
                "         ordered     = ?," +
                "         description = ?," +
                "         status      = ?" +
                "     where id = ?";

        //3.获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //4.设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);
        pstmt.setInt(6,id);
        //5.执行sql
        int count = pstmt.executeUpdate();//影响的行数

        //6.输出结果
        System.out.println(count > 0);

        //7.释放资源
        pstmt.close();
        conn.close();
    }

    /*
     删除
     1.sql：
     delete from tb_brand where id = ?
     2.参数：需要，id
     3.结果：布尔类型
      */
    @Test
    public void testDelete() throws Exception {
        // 接收页面提交的参数

        int id = 4;

        //1.获取连接对象
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));

        DataSource dataSource= DruidDataSourceFactory.createDataSource(prop);

        Connection conn = dataSource.getConnection();
        //2.定义sql
        String sql = "delete from tb_brand where id = ?";

        //3.获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //4.设置参数
        pstmt.setInt(1,id);
        //5.执行sql
        int count = pstmt.executeUpdate();//影响的行数

        //6.输出结果
        System.out.println(count > 0);

        //7.释放资源
        pstmt.close();
        conn.close();
    }

}
