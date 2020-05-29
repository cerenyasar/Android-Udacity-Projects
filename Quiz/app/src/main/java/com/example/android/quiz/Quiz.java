package com.example.android.quiz;

/**
 * Created by maron on 3.02.2018.
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import pl.droidsonroids.gif.GifImageView;


public class Quiz extends AppCompatActivity{
    int total=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);

    }
    /*
        Update total
        Display second question
     */
    public void next1(View v){
        //checks the answer for question
        RadioButton button = (RadioButton) findViewById(R.id.q1c);
        RadioButton button1 = (RadioButton) findViewById(R.id.q1a);
        RadioButton button2 = (RadioButton) findViewById(R.id.q1b);
        RadioButton button3 = (RadioButton) findViewById(R.id.q1d);
        if (button.isChecked()) {
            total++;
            setContentView(R.layout.quiz2);
        }else if (button1.isChecked() || button2.isChecked() || button3.isChecked()){
            setContentView(R.layout.quiz2);
        }else{
            Toast.makeText(this, R.string.forget, Toast.LENGTH_LONG).show();
        }
        Toast.makeText(this,"You get "+total+" out of 10", Toast.LENGTH_LONG).show();
    }
    /*
        Update total
        Display third question
     */
    public void next2(View v){
        //checks the answer for question
        RadioButton button = (RadioButton) findViewById(R.id.q2b);
        RadioButton button1 = (RadioButton) findViewById(R.id.q2a);
        RadioButton button2 = (RadioButton) findViewById(R.id.q2c);
        if (button.isChecked()) {
            total++;
            setContentView(R.layout.quiz3);
        }else if (button1.isChecked() || button2.isChecked() ){
            setContentView(R.layout.quiz3);
        }else{
            Toast.makeText(this, R.string.forget, Toast.LENGTH_LONG).show();
        }
        Toast.makeText(this,"You get "+total+" out of 10", Toast.LENGTH_LONG).show();
    }
    /*
        Update total
        Display fourth question
     */
    public void next3(View v){
        //checks the answer for question
        RadioButton button = (RadioButton) findViewById(R.id.q3b);
        RadioButton button1 = (RadioButton) findViewById(R.id.q3a);
        RadioButton button2 = (RadioButton) findViewById(R.id.q3c);
        RadioButton button3 = (RadioButton) findViewById(R.id.q3d);
        if (button.isChecked()) {
            total++;
            setContentView(R.layout.quiz4);
        }else if (button1.isChecked() || button2.isChecked() || button3.isChecked()){
            setContentView(R.layout.quiz4);
        }else{
            Toast.makeText(this, R.string.forget, Toast.LENGTH_LONG).show();
        }
        Toast.makeText(this,"You get "+total+" out of 10", Toast.LENGTH_LONG).show();
    }
    /*
        Update total
        Display fifth question
     */
    public void next4(View v){
        //checks the answer for question
        CheckBox button = (CheckBox) findViewById(R.id.q4a);
        CheckBox button1 = (CheckBox) findViewById(R.id.q4b);
        CheckBox button2 = (CheckBox) findViewById(R.id.q4c);
        CheckBox button3 = (CheckBox) findViewById(R.id.q4d);
        CheckBox button4 = (CheckBox) findViewById(R.id.q4e);
        CheckBox button5 = (CheckBox) findViewById(R.id.q4f);
        if (button.isChecked() && button1.isChecked() && button2.isChecked() && button4.isChecked() &&
                !button3.isChecked() && !button5.isChecked()) {
            total++;
            setContentView(R.layout.quiz5);
        }else if (button.isChecked() || button1.isChecked() || button2.isChecked()
                || button3.isChecked()|| button4.isChecked() || button5.isChecked()){
            setContentView(R.layout.quiz5);
        }else{
            Toast.makeText(this, R.string.forget, Toast.LENGTH_LONG).show();
        }
        Toast.makeText(this,"You get "+total+" out of 10", Toast.LENGTH_LONG).show();
    }
    /*
        Update total
        Display sixth question
     */
    public void next5(View v){
        //checks the answer for question 2
        RadioButton button = (RadioButton) findViewById(R.id.q5d);
        RadioButton button1 = (RadioButton) findViewById(R.id.q5a);
        RadioButton button2 = (RadioButton) findViewById(R.id.q5c);
        RadioButton button3 = (RadioButton) findViewById(R.id.q5b);
        if (button.isChecked()) {
            total++;
            setContentView(R.layout.quiz6);
        }else if (button1.isChecked() || button2.isChecked() || button3.isChecked()){
            setContentView(R.layout.quiz6);
        }else{
            Toast.makeText(this, R.string.forget, Toast.LENGTH_LONG).show();
        }
        Toast.makeText(this,"You get "+total+" out of 10", Toast.LENGTH_LONG).show();
    }
    /*
        Update total
        Display seventh question
     */
    public void next6(View v){
        //checks the answer for question 2
        RadioButton button = (RadioButton) findViewById(R.id.q6d);
        RadioButton button1 = (RadioButton) findViewById(R.id.q6a);
        RadioButton button2 = (RadioButton) findViewById(R.id.q6c);
        RadioButton button3 = (RadioButton) findViewById(R.id.q6b);
        if (button.isChecked()) {
            total++;
            setContentView(R.layout.quiz7);
        }else if (button1.isChecked() || button2.isChecked() || button3.isChecked()){
            setContentView(R.layout.quiz7);
        }else{
            Toast.makeText(this, R.string.forget, Toast.LENGTH_LONG).show();
        }
        Toast.makeText(this,"You get "+total+" out of 10", Toast.LENGTH_LONG).show();
    }
    /*
        Update total
        Display eighth question
     */
    public void next7(View v){
        //checks the answer for question 2
        RadioButton button = (RadioButton) findViewById(R.id.q7a);
        RadioButton button1 = (RadioButton) findViewById(R.id.q7b);
        RadioButton button2 = (RadioButton) findViewById(R.id.q7c);
        RadioButton button3 = (RadioButton) findViewById(R.id.q7d);
        if (button.isChecked()) {
            total++;
            setContentView(R.layout.quiz8);
        }else if (button1.isChecked() || button2.isChecked() || button3.isChecked()){
            setContentView(R.layout.quiz8);
        }else{
            Toast.makeText(this, R.string.forget, Toast.LENGTH_LONG).show();
        }
        Toast.makeText(this,"You get "+total+" out of 10", Toast.LENGTH_LONG).show();
    }
    /*
        Update total
        Display ninth question
     */
    public void next8(View v){
        //checks the answer for question 2
        RadioButton button = (RadioButton) findViewById(R.id.q8b);
        RadioButton button1 = (RadioButton) findViewById(R.id.q8a);
        RadioButton button2 = (RadioButton) findViewById(R.id.q8c);
        RadioButton button3 = (RadioButton) findViewById(R.id.q8d);
        if (button.isChecked()) {
            total++;
            setContentView(R.layout.quiz9);
        }else if (button1.isChecked() || button2.isChecked() || button3.isChecked()){
            setContentView(R.layout.quiz9);
        }else{
            Toast.makeText(this,R.string.forget, Toast.LENGTH_LONG).show();
        }
        Toast.makeText(this,"You get "+total+" out of 10", Toast.LENGTH_LONG).show();
    }
    /*
        Update total
        Display tenth question
     */
    public void next9(View v){
        //checks the answer for question 2
        RadioButton button = (RadioButton) findViewById(R.id.q9c);
        RadioButton button1 = (RadioButton) findViewById(R.id.q9a);
        RadioButton button2 = (RadioButton) findViewById(R.id.q9b);
        RadioButton button3 = (RadioButton) findViewById(R.id.q9d);
        if (button.isChecked()) {
            total++;
            setContentView(R.layout.quiz10);
        }else if (button1.isChecked() || button2.isChecked() || button3.isChecked()){
            setContentView(R.layout.quiz10);
        }else{
            Toast.makeText(this, R.string.forget, Toast.LENGTH_LONG).show();
        }
        Toast.makeText(this,"You get "+total+" out of 10", Toast.LENGTH_LONG).show();
    }
    /*
        Update total
        Call result function
     */
    public void next10(View v){
        //checks the answer for question 2
        EditText whatIsAnswer = (EditText) findViewById(R.id.q10);
        String answer = whatIsAnswer.getText().toString().trim();
        answer = answer.toLowerCase();
        if (answer.equals("spine breaker") || answer.equals("spine  breaker")) {
            total++;
            result();
        }else{
            result();
        }
    }
    /*
        Display Result
     */
    public void result(){
        setContentView(R.layout.end_page);
        GifImageView newGif = (GifImageView) findViewById(R.id.gif);
        TextView newText1 =(TextView) findViewById(R.id.text1);
        TextView newText2 =(TextView) findViewById(R.id.text2);
        Bundle bundle = getIntent().getExtras();
        if(total<=10 && total>7){
            newGif.setImageResource(R.mipmap.min_genius);
            newText1.setText("You get "+total+" out of 10, "+bundle.get("name")+" !");
            newText2.setText(R.string.result5);
        }else if(total==7 || total==6){
            newGif.setImageResource(R.mipmap.fun);
            newText1.setText("You get "+total+" out of 10, "+bundle.get("name")+" !");
            newText2.setText(R.string.result4);
        }else if(total==5 || total==4){
            newGif.setImageResource(R.mipmap.attention);
            newText1.setText("You get "+total+" out of 10, "+bundle.get("name")+" !");
            newText2.setText(R.string.result3);
        }else if(total==3 || total==2){
            newGif.setImageResource(R.mipmap.hug);
            newText1.setText("You get "+total+" out of 10, "+bundle.get("name")+" !");
            newText2.setText(R.string.result2);
        }else if(total==1 || total==0){
            newText1.setText("You get "+total+" out of 10, "+bundle.get("name")+" !");
            newGif.setImageResource(R.mipmap.rm_no_jams);
            newText2.setText(R.string.result1);
        }
        Toast.makeText(this,"You get "+total+" out of 10", Toast.LENGTH_LONG).show();
    }
    public void startOver(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
