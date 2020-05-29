package com.example.android.tourguide;

/**
 * Created by maron on 8.07.2018.
 */

public class Item {

    private String title;
    private String description;
    private String type;
    private int imgResId=NO_IMAGE_PROVIDED;
    private Float latitude;
    private Float longtitude;
    private String phone;
    private String web;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Item(String title,String type,int imgResId) {
        this.title = title;
        this.type = type;
        this.imgResId = imgResId;
    }
    public Item(String title, String type, String description, int imgResId , Float latitude,
                Float longtitude,String phone, String web) {
        this.title = title;
        this.type = type;
        this.description = description;
        this.imgResId = imgResId;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.phone = phone;
        this.web = web;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Float longtitude) {
        this.longtitude = longtitude;
    }

    public String getType() {return type; }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImgResId() {
        return imgResId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImgResId(int imgResId) {
        this.imgResId = imgResId;
    }
    public boolean hasImage(){
        return imgResId!=NO_IMAGE_PROVIDED;
    }
}
