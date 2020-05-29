package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by maron on 16.04.2018.
 */

public class SongActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Word> words = new ArrayList<Word>();
        String[] listValueH= getResources().getStringArray(R.array.hope_world);
        for(int i =0;i< listValueH.length;i++){
            words.add(new Word(R.drawable.hopeworld,listValueH[i],getResources().getString(R.string.jhope)));
        }
        String[] listValueL = getResources().getStringArray(R.array.love_yourself);
        for(int i =0;i< listValueL.length;i++){
            words.add(new Word(R.drawable.bts_love_yourself,listValueL[i],getResources().getString(R.string.bts)));
        }
        WordAdapter adapter = new WordAdapter(this,words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(SongActivity.this,PlayActivity.class);
                if(i<7){
                    intent.putExtra("image", R.drawable.hopeworld);
                    intent.putExtra("Song",R.array.hope_world);
                    intent.putExtra("position",i);
                    intent.putExtra("Singer",R.string.jhope);
                }else if(i>=7){
                    intent.putExtra("image", R.drawable.bts_love_yourself);
                    intent.putExtra("Song",R.array.love_yourself);
                    intent.putExtra("position",i-7);
                    intent.putExtra("Singer",R.string.bts);
                }
                startActivity(intent);
            }
        });
        listView.setAdapter(adapter);

        TextView items = (TextView) findViewById(R.id.playlist);

        // Set a click listener on that View
        items.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(SongActivity.this,PlaylistActivity.class);
                startActivity(numbersIntent);
            }
        });
        TextView items2 = (TextView) findViewById(R.id.songs);

        // Set a click listener on that View
        items2.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(SongActivity.this,SongActivity.class);
                startActivity(numbersIntent);
            }
        });
        TextView items3 = (TextView) findViewById(R.id.albums);

        // Set a click listener on that View
        items3.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(SongActivity.this,AlbumActivity.class);
                startActivity(numbersIntent);
            }
        });
        TextView items4 = (TextView) findViewById(R.id.artist);

        // Set a click listener on that View
        items4.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(SongActivity.this,ArtistActivity.class);
                startActivity(numbersIntent);
            }
        });

    }
}
