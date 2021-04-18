package com.example.demo.jdbc;


import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HikariAppliction {
    public static void main(String[] args) {
        ResultSet rs= null;
        try{
            HikariDataSource hikariDataSource = new HikariDataSource();
            Connection connection = hikariDataSource.getConnection();
            Statement sta = connection.createStatement();
            //查询
            String sqlStatement = "SELECT * FROM kimming_class";
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
            JDBCConnection.closeConnection(connection, sta, rs);
        }catch (Exception e){

        }

    }
}
