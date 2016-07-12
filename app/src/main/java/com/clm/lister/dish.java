package com.clm.lister;

/**
 * Created by jbt on 7/12/2016.
 */
public class dish {
    @Override
    public String toString() {
        return getDishName();
    }

    private String dishName;
    private String restrauntName;
    private double dishPrice;

    public dish(String dishName, String restrauntName, double dishPrice) {
        this.dishName = dishName;
        this.restrauntName = restrauntName;
        this.dishPrice = dishPrice;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getRestrauntName() {
        return restrauntName;
    }

    public void setRestrauntName(String restrauntName) {
        this.restrauntName = restrauntName;
    }

    public double getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(double dishPrice) {
        this.dishPrice = dishPrice;
    }
}
