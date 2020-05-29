package com.example.android.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void start(View v){
        //if the player didn't enter his name pop up a toast,dont go to the next layout

        if (getName().isEmpty()) {
            Toast.makeText(this, "You forgot to enter Your Name", Toast.LENGTH_LONG).show();
        } else {

            Intent i = new Intent(this, Quiz.class);
            i.putExtra("name", getName());
            startActivity(i);
            Log.i("Mainactivity", getName());
        }
    }

    //get the player's name
    private String getName() {
        EditText whatIsName = (EditText) findViewById(R.id.entername);
        String name = whatIsName.getText().toString();

        return name;


    }
}
