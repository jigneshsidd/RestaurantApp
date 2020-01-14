package com.example.restaurantapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BgColor implements Serializable
{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("tint")
    @Expose
    private String tint;
    private final static long serialVersionUID = -7120728487122634405L;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTint() {
        return tint;
    }

    public void setTint(String tint) {
        this.tint = tint;
    }
}
