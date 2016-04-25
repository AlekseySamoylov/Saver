package com.alekseysamoylov.saver;

import com.alekseysamoylov.saver.parsing.ReadOrdersFromDB;
import com.alekseysamoylov.saver.models.Orders;
import org.junit.Test;

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
