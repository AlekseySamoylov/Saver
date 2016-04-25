package com.alekseysamoylov.saver;

import com.alekseysamoylov.saver.models.*;
import com.alekseysamoylov.saver.parsing.ReadOrdersFromDB;
import com.alekseysamoylov.saver.storages.JDBConnection;
import com.alekseysamoylov.saver.storages.StatementsProperty;
import com.alekseysamoylov.saver.xmlModels.Orders;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by alekseysamoylov on 4/24/16.
 *
 */
public class TestOrders {

    @Test
    public void ordersTest(){
        Orders orders = new ReadOrdersFromDB().getOrders();
            System.out.println(orders);
    }
}
