package com.alekseysamoylov.saver.storages;

import java.sql.Connection;

/**
 * Created by alekseysamoylov on 4/24/16.
 */
public interface ConnectionInterface {
    public Connection getConnection();
    public void closeConnection();
}
