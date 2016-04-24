package com.alekseysamoylov.saver.models;

/**
 * Created by alekseysamoylov on 4/24/16.
 */
public class Manager {
    private int managerId;
    private String name;
    private String other;

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
