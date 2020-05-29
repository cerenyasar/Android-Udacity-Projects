package com.example.android.musicapp;

import android.media.Image;
import android.widget.ImageView;

/**
 * Created by maron on 14.04.2018.
 */

public class Word {
    private String mName;

    private String mSingerName=null;

    private int mImageResourceId;

    public  Word(int ImageResourceId,String name) {
        mName=name;
        mImageResourceId=ImageResourceId;
    }


    public  Word(int ImageResourceId,String name, String singerName) {
        mName=name;
        mSingerName=singerName;
        mImageResourceId=ImageResourceId;
    }

    public String getmName() {
        return mName;
    }

    public String getmSingerName() {
        return mSingerName;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasSıngerName(){
        return mSingerName != null;
    }
}
