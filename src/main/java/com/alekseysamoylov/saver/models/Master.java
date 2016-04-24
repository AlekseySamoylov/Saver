package com.alekseysamoylov.saver.models;

/**
 * Created by alekseysamoylov on 4/24/16.
 */
public class Master {
    private int masterId;
    private String name;
    private String phone;

    public int getMasterId() {
        return masterId;
    }

    public void setMasterId(int masterId) {
        this.masterId = masterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
