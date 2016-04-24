package com.alekseysamoylov.saver.xmlModels;

import com.alekseysamoylov.saver.models.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alekseysamoylov on 4/24/16.
 */
public class Orders {
    private List<Order> orderList = new ArrayList<>();

    public void addOrder(Order order){
        orderList.add(order);
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
