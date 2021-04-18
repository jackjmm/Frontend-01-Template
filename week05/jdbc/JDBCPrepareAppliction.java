package com.example.demo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JDBCPrepareAppliction {

    public static void main(String[] args) {
        try{
            Connection connection = JDBCConnection.getConnection();
            connection.setAutoCommit(false);//将自动提交关闭
            PreparedStatement pstmt = connection.prepareStatement("update kimming_class set class_name=? where class=?");
            pstmt.setString(1, "java2期");
            pstmt.setInt(2, 2);
            pstmt.addBatch();
            pstmt.executeBatch();
            pstmt.close();
            connection.commit();//执行完后，手动提交事务
            connection.setAutoCommit(true);//再把自动提交打开，避免影响其他需要自动提交的操作
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
