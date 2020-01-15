package com.example.restaurantapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

class Review implements Serializable
{

    @SerializedName("review")
    @Expose
    private List<Object> review = null;
    private final static long serialVersionUID = 5405853638396072853L;

    public List<Object> getReview() {
        return review;
    }

    public void setReview(List<Object> review) {
        this.review = review;
    }
}
