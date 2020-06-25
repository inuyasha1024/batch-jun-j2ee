package com.octans.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static final String url = "jdbc:mysql://database-1.cryo7sf5ijou.us-east-2.rds.amazonaws.com:3306/course?useSSL=false";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String username = "admin";
    private static final String password = "jj7539518426";

    public static Connection getConnection(){
        try {
            Class.forName(driver);
            Connection connection= DriverManager.getConnection(url,username,password);
            return connection;
        }catch (Exception e){
            return null;
        }

    }
}
