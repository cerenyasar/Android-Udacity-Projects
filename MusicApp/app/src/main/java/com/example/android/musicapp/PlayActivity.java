package com.example.android.musicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        Bundle bundle = getIntent().getExtras();
        ImageView imgView = (ImageView) findViewById(R.id.image);
        TextView textView1= (TextView)findViewById(R.id.song_name);
        TextView textView2= (TextView)findViewById(R.id.artist);
        LinearLayout layout = (LinearLayout)findViewById(R.id.backgroundImage);
        if ( bundle!=null){
            imgView.setImageResource(bundle.getInt("image"));
            String[] listValue= getResources().getStringArray(bundle.getInt("Song"));
            textView1.setText(listValue[bundle.getInt("position")]);
            textView2.setText(getResources().getString(bundle.getInt("Singer")));
            layout.setBackgroundResource(bundle.getInt("image"));
        }
    }
}
