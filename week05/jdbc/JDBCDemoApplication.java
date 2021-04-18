package com.example.demo.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemoApplication {
    private static String sqlStatement;
    public static void main(String[] args) throws Exception {
        //通过工具类获取数据库连接对象
        Connection con = JDBCConnection.getConnection();
        //通过连接创建数据库执行对象
        Statement sta = con.createStatement();
        //为查询的结果集准备接收对象
        ResultSet rs = null;
        //查询
        sqlStatement = "SELECT * FROM kimming_class";
        rs = sta.executeQuery(sqlStatement);
        //增加
        sqlStatement = "INSERT INTO kimming_class VALUES('1','teacher','kimming')";
        sta.executeUpdate(sqlStatement);
        //更新
        sqlStatement = "UPDATE DEPT SET student_number='200' WHERE Klass = '2'";
        sta.executeUpdate(sqlStatement);
        //删除
        sqlStatement = "DELETE FROM kimming_class WHERE Klass = '2'";
        sta.executeUpdate(sqlStatement);
        JDBCConnection.closeConnection(con, sta, rs);
    }
}
