package com.example.restaurantapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class HasMenuStatus implements Serializable {

    @SerializedName("delivery")
    @Expose
    private Integer delivery;
    @SerializedName("takeaway")
    @Expose
    private Integer takeaway;
    private final static long serialVersionUID = 893119417792987935L;

    public Integer getDelivery() {
        return delivery;
    }

    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
    }

    public Integer getTakeaway() {
        return takeaway;
    }

    public void setTakeaway(Integer takeaway) {
        this.takeaway = takeaway;
    }
}
