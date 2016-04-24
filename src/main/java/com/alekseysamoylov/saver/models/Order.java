package com.alekseysamoylov.saver.models;

import java.sql.Date;
import java.util.List;

/**
 * Created by alekseysamoylov on 4/24/16.
 */
public class Order {
    private int orderId;
    private Date orderDate;
    private Manager manager;
    private String orderName;
    private ClientsCar clientsCar;
    private float summ;
    private float purchase;
    private List<Operation> operationList;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public ClientsCar getClientsCar() {
        return clientsCar;
    }

    public void setClientsCar(ClientsCar clientsCar) {
        this.clientsCar = clientsCar;
    }

    public float getSumm() {
        return summ;
    }

    public void setSumm(float summ) {
        this.summ = summ;
    }

    public float getPurchase() {
        return purchase;
    }

    public void setPurchase(float purchase) {
        this.purchase = purchase;
    }

    public List<Operation> getOperationList() {
        return operationList;
    }

    public void setOperationList(List<Operation> operationList) {
        this.operationList = operationList;
    }
}
