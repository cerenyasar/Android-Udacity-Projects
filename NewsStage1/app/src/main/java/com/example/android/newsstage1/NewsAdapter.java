package com.example.android.newsstage1;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {


    public NewsAdapter(Context context, List<News> earthquakes){
        super(context, 0, earthquakes);
    }


    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        //View listItemView = convertView;
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_view, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        News currentNews = getItem(position);

        String title = currentNews.getTitle();
        TextView titleView = (TextView) convertView.findViewById(R.id.title);
        titleView.setText(title);

        String section= currentNews.getSection();
        TextView sectionView = (TextView) convertView.findViewById(R.id.section);
        sectionView.setText(section);

        String author= currentNews.getAuthor();
        TextView authorView = (TextView) convertView.findViewById(R.id.author);
        authorView.setText(author);

        String date= currentNews.getDate();
        TextView dateView = (TextView) convertView.findViewById(R.id.date);
        dateView.setText(date);

        String time= currentNews.getTime();
        TextView timeView = (TextView) convertView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        timeView.setText(time);
        // Return the list item view that is now showing the appropriate data
        return convertView;
    }

}
