package com.example.restaurantapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("zomato_handle")
    @Expose
    private String zomatoHandle;
    @SerializedName("foodie_level")
    @Expose
    private String foodieLevel;
    @SerializedName("foodie_level_num")
    @Expose
    private Integer foodieLevelNum;
    @SerializedName("foodie_color")
    @Expose
    private String foodieColor;
    @SerializedName("profile_url")
    @Expose
    private String profileUrl;
    @SerializedName("profile_image")
    @Expose
    private String profileImage;
    @SerializedName("profile_deeplink")
    @Expose
    private String profileDeeplink;
    private final static long serialVersionUID = -2224099642317590932L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZomatoHandle() {
        return zomatoHandle;
    }

    public void setZomatoHandle(String zomatoHandle) {
        this.zomatoHandle = zomatoHandle;
    }

    public String getFoodieLevel() {
        return foodieLevel;
    }

    public void setFoodieLevel(String foodieLevel) {
        this.foodieLevel = foodieLevel;
    }

    public Integer getFoodieLevelNum() {
        return foodieLevelNum;
    }

    public void setFoodieLevelNum(Integer foodieLevelNum) {
        this.foodieLevelNum = foodieLevelNum;
    }

    public String getFoodieColor() {
        return foodieColor;
    }

    public void setFoodieColor(String foodieColor) {
        this.foodieColor = foodieColor;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getProfileDeeplink() {
        return profileDeeplink;
    }

    public void setProfileDeeplink(String profileDeeplink) {
        this.profileDeeplink = profileDeeplink;
    }
}
