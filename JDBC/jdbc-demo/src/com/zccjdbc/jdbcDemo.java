package com.zccjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1.注册
        //Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取链接
        String url ="jdbc:mysql://127.0.0.1:3306/test";
        String userName ="root";
        String password ="zcc060116";
        Connection conn = DriverManager.getConnection(url, userName, password);

        //3.定义sql
        String sql = "insert into student values(7,'斯卡蒂','20060818',3);";

        //4.获取sql执行对象statement
        Statement stmt = conn.createStatement();

        //5.执行sql
        int i = stmt.executeUpdate(sql);//受影响的行数

        //6.处理结果
        System.out.println(i);

        //7.释放资源
        stmt.close();
        conn.close();

    }
}
