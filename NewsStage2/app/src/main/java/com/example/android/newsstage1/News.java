package com.example.android.newsstage1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class News {
    private String title;
    private String section;
    private String url;
    private String date;
    private String time;
    private String author;

    public News(String title, String section, String url, String date, String time, String author) {
        this.title = title;
        this.section = section;
        this.url = url;
        this.date = date;
        this.time = time;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
