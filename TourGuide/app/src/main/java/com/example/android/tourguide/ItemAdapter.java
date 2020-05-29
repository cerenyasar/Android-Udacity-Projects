package com.example.android.tourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by maron on 11.07.2018.
 */

public class ItemAdapter extends ArrayAdapter<Item> {

    public ItemAdapter(@NonNull Context context, ArrayList<Item> arrItem) {
        super(context,0,arrItem);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // View listItemView = convertView;

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_view, parent, false);
        }
        final Item local_item = getItem(position);

        ImageView imgView= (ImageView) convertView.findViewById(R.id.main_image);
        if (local_item.hasImage()){
            imgView.setImageResource(local_item.getImgResId());
            imgView.setVisibility(View.VISIBLE);
        }else{
            imgView.setVisibility(View.GONE);
        }

        TextView miwokTextView = (TextView) convertView.findViewById(R.id.main_title);
        miwokTextView.setText(local_item.getTitle());
        TextView defaultTextView = (TextView) convertView.findViewById(R.id.main_type);
        defaultTextView.setText(local_item.getType());
        return convertView;

    }
}
