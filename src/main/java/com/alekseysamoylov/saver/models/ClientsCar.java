package com.alekseysamoylov.saver.models;

/**
 * Created by alekseysamoylov on 4/24/16.
 */
public class ClientsCar {
    private int clientCarId;
    private Car car;
    private Client client;
    private String carNumber;

    public int getClientCarId() {
        return clientCarId;
    }

    public void setClientCarId(int clientCarId) {
        this.clientCarId = clientCarId;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
}
