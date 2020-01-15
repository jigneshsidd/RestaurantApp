package com.example.restaurantapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

class Photo implements Serializable
{
    @SerializedName("photo")
    @Expose
    private Photo_ photo;
    private final static long serialVersionUID = -5460672092939156354L;

    public Photo_ getPhoto() {
        return photo;
    }

    public void setPhoto(Photo_ photo) {
        this.photo = photo;
    }
}
