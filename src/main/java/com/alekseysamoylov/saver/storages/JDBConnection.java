package com.alekseysamoylov.saver.storages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by alekseysamoylov on 4/24/16.
 *
 */
public class JDBConnection implements ConnectionInterface{
    private Connection connection;

    public Connection getConnection(){
        try {
            Properties properties = new ConnectionProperty().getProperties();
            Class.forName(properties.getProperty("className"));
            connection = DriverManager.getConnection(
                    properties.getProperty("path"),
                    properties.getProperty("login"),
                    properties.getProperty("password"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
