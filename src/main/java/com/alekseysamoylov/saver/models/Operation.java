package com.alekseysamoylov.saver.models;

/**
 * Created by alekseysamoylov on 4/24/16.
 */
public class Operation {
    private int operationId;
    private Master master;
    private Work work;
    private float price;
    private int numberWork;
    private float summ;
    private int orderId;

    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumberWork() {
        return numberWork;
    }

    public void setNumberWork(int numberWork) {
        this.numberWork = numberWork;
    }

    public float getSumm() {
        return summ;
    }

    public void setSumm(float summ) {
        this.summ = summ;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
