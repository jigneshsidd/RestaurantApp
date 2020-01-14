package com.example.restaurantapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Restaurant implements Serializable
{
    @SerializedName("restaurant")
    @Expose
    private Restaurant_ restaurant;
    private final static long serialVersionUID = 7999354249080497517L;

    public Restaurant_ getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant_ restaurant) {
        this.restaurant = restaurant;
    }
}
