package com.itheima.jdbc.druid.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC 快速入门
 */
public class JDBCDemo {
    public static void main(String[] args) {
        // 使用 try-with-resources 自动关闭资源
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db1?useSSL=false&serverTimezone=UTC", "root", "123456");
             Statement stmt = conn.createStatement()) {

            // 1. 注册驱动（MySQL 8.x 可以省略）
            //Class.forName("com.mysql.cj.com.itheima.jdbc.com.itheima.jdbc.druid.druid.jdbc.Driver");

            // 2. 定义 SQL
            String sql = "UPDATE course SET ccredit = 2 WHERE cno = 'C001'";

            // 3. 执行 SQL
            int count = stmt.executeUpdate(sql); // 受影响的行数

            // 4. 处理结果
            System.out.println("受影响的行数: " + count);
        } catch (Exception e) {
            e.printStackTrace(); // 打印异常信息
        }
    }
}