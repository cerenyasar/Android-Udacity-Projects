package com.example.android.volleyballscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int scoreA = 0;
    int scoreB = 0;
    int setA = 0;
    int setB = 0;
    int warningA = 0;
    int warningB = 0;
    int faultA = 0;
    int faultB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the given score for Team A.
     */
    public void display(int score, int id) {
        TextView scoreView = (TextView) findViewById(id);
        scoreView.setText(String.valueOf(score));

    }

    public void displayResult(String s) {
        TextView scoreView = (TextView) findViewById(R.id.result);
        scoreView.setText(String.valueOf(s));
    }

    public void Reset(View v) {
        scoreA = 0;
        scoreB = 0;
        setA = 0;
        setB = 0;
        warningA = 0;
        warningB = 0;
        faultA = 0;
        faultB = 0;
        display(scoreA, R.id.team_a_score);
        display(scoreB, R.id.team_b_score);
        display(setA, R.id.team_a_set);
        display(setB, R.id.team_b_set);
        display(warningA, R.id.team_a_warning);
        display(warningB, R.id.team_b_warning);
        display(faultA, R.id.team_a_fault);
        display(faultB, R.id.team_b_fault);

        displayResult("Result");
    }

    public void addScoreA(View v) {
        scoreA = scoreA + 1;
        display(scoreA, R.id.team_a_score);
        if (setA == 3) {
            displayResult("Result: Team A Win!!");
        } else if ((setB + setA) == 4 && scoreA >= 15 && (scoreA - scoreB) >= 2) {
            setA = setA + 1;
            display(setA, R.id.team_a_set);
            if (setA == 3) {
                displayResult("Result: Team A Win!!");
            }
        } else if (scoreA >= 25 && (scoreA - scoreB) >= 2) {
            setA = setA + 1;
            display(setA, R.id.team_a_set);
            if (setA == 3) {
                displayResult("Result: Team A Win!!");
            } else {
                scoreA = 0;
                scoreB = 0;
                display(scoreA, R.id.team_a_score);
                display(scoreB, R.id.team_b_score);
            }
        }
    }

    public void addScoreB(View v) {
        scoreB = scoreB + 1;
        display(scoreB, R.id.team_b_score);
        if (setB == 3) {
            displayResult("Result: Team B Win!!");
        } else if ((setB + setA) == 4 && scoreB >= 15 && (scoreB - scoreA) >= 2) {
            setB = setB + 1;
            display(setB, R.id.team_b_set);
            if (setB == 3) {
                displayResult("Result: Team B Win!!");
            }
        } else if (scoreB >= 25 && (scoreB - scoreA) >= 2) {
            setB = setB + 1;
            display(setB, R.id.team_b_set);
            if (setB == 3) {
                displayResult("Result: Team B Win!!");
            } else {
                scoreA = 0;
                scoreB = 0;
                display(scoreA, R.id.team_a_score);
                display(scoreB, R.id.team_b_score);
            }
        }
    }

    public void faultA(View v) {
        faultA = faultA + 1;
        display(faultA, R.id.team_a_fault);
        addScoreB(v);
    }

    public void faultB(View v) {
        faultB = faultB + 1;
        display(faultB, R.id.team_b_fault);
        addScoreA(v);
    }

    public void warningA(View v) {
        warningA = warningA + 1;
        display(warningA, R.id.team_a_warning);
        addScoreB(v);
    }

    public void warningB(View v) {
        warningB = warningB + 1;
        display(warningB, R.id.team_b_warning);
        addScoreA(v);
    }

}
