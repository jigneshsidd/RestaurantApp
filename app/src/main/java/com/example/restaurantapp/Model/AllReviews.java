package com.example.restaurantapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class AllReviews implements Serializable
{

    @SerializedName("reviews")
    @Expose
    private List<Review> reviews = null;
    private final static long serialVersionUID = -4705836461698863537L;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
