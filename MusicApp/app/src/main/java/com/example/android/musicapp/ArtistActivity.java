package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by maron on 16.04.2018.
 */

public class ArtistActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.drawable.hopeworld,getResources().getString(R.string.jhope)));
        words.add(new Word(R.drawable.bts_love_yourself,getResources().getString(R.string.bts)));
        // Create a variable to keep track of the current index position
        WordAdapter adapter = new WordAdapter(this,words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        TextView items = (TextView) findViewById(R.id.playlist);

        // Set a click listener on that View
        items.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(ArtistActivity.this,PlaylistActivity.class);
                startActivity(numbersIntent);
            }
        });
        TextView items2 = (TextView) findViewById(R.id.songs);

        // Set a click listener on that View
        items2.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(ArtistActivity.this,SongActivity.class);
                startActivity(numbersIntent);
            }
        });
        TextView items3 = (TextView) findViewById(R.id.albums);

        // Set a click listener on that View
        items3.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(ArtistActivity.this,AlbumActivity.class);
                startActivity(numbersIntent);
            }
        });
        TextView items4 = (TextView) findViewById(R.id.artist);

        // Set a click listener on that View
        items4.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(ArtistActivity.this,ArtistActivity.class);
                startActivity(numbersIntent);
            }
        });

    }
}
