package com.example.android.musicapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * Created by maron on 14.04.2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Context context, ArrayList<Word> pWords) {
        super(context,0, pWords);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_view, parent, false);
        }
        Word local_word = getItem(position);
        ImageView imgView = (ImageView) listItemView.findViewById(R.id.list_image);
        imgView.setImageResource(local_word.getmImageResourceId());
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.text1);
        miwokTextView.setText(local_word.getmName());
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.text2);
        if (local_word.hasSıngerName()){
            defaultTextView.setText(local_word.getmSingerName());
            defaultTextView.setVisibility(View.VISIBLE);
        }else{
            defaultTextView.setVisibility(View.GONE);
        }
        return listItemView;
    }

}
