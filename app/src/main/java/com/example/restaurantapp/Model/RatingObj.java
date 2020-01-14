package com.example.restaurantapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RatingObj implements Serializable
{

    @SerializedName("title")
    @Expose
    private Title title;
    @SerializedName("bg_color")
    @Expose
    private BgColor bgColor;
    private final static long serialVersionUID = -2479005618879641813L;

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public BgColor getBgColor() {
        return bgColor;
    }

    public void setBgColor(BgColor bgColor) {
        this.bgColor = bgColor;
    }

}
