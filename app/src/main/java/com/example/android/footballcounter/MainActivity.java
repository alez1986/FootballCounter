package com.example.android.footballcounter;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int scoreTeamA = 0;
    private int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addThree(View v) {
        String teamName = v.getTag().toString();
        if (teamName.equals("teamA")) {
            scoreTeamA += 3;
            displayForTeamA(scoreTeamA);
        } else {
            scoreTeamB += 3;
            displayForTeamB(scoreTeamB);
        }
    }

    public void addTwo(View v) {
        String teamName = v.getTag().toString();
        if (teamName.equals("teamA")) {
            scoreTeamA += 2;
            displayForTeamA(scoreTeamA);
        } else {
            scoreTeamB += 2;
            displayForTeamB(scoreTeamB);
        }
    }

    public void addFive(View v) {
        String teamName = v.getTag().toString();
        if (teamName.equals("teamA")) {
            scoreTeamA += 5;
            displayForTeamA(scoreTeamA);
        } else {
            scoreTeamB += 5;
            displayForTeamB(scoreTeamB);
        }
    }

    // Team A
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    // Team B
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    // Reset both scores
    public void reset(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("scoreTeamA", scoreTeamA);
        outState.putInt("scoreTeamB", scoreTeamB);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        scoreTeamB = savedInstanceState.getInt("scoreTeamB");
        scoreTeamA = savedInstanceState.getInt("scoreTeamA");
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}
