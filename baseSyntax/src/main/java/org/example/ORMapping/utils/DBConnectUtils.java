package org.example.ORMapping.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectUtils {

    private static Connection connect = null;

    public static Connection getConnect() {
        String url = "jdbc:mysql://localhost:3306/myweibo?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false";
        String user = "root";
        String password = "123456789";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connect;
    }

    public static void close() {
        if (connect != null){
            try {
                connect.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
