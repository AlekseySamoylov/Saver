package com.alekseysamoylov.saver.models;

import com.alekseysamoylov.saver.models.Operation;
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

    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();

            for (Order order : orderList) {
                ret.append(order.getClientsCar().getClient().getFirstName() +
                        " " + order.getClientsCar().getClient().getSecondName() +
                        " \n" + order.getManager().getName() + " \n" + order.getClientsCar().getCar().getMark() +
                        " " + order.getClientsCar().getCar().getModel() +
                        " " + order.getClientsCar().getCarNumber() +
                        " \n" + order.getOrderName() + ":\n");
                for (Operation operation : order.getOperationList()) {
                    ret.append(operation.getWork().getWorkName() + " " + operation.getWork().getPrice() + "\n");
                }
                ret.append("******************************************************* \n\n");
            }

        return ret.toString();
    }
}
