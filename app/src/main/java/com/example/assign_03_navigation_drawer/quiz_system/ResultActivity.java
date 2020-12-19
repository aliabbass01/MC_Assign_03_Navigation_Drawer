package com.example.assign_03_navigation_drawer.quiz_system;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assign_03_navigation_drawer.R;

public class ResultActivity extends AppCompatActivity
{
    private TextView resultTextView;
    private TextView nameTextView;
    private String score = "";
    private String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        getSupportActionBar().setTitle("Result");

        resultTextView = (TextView) findViewById(R.id.score_textView);
        nameTextView = (TextView) findViewById(R.id.name_textView);

        score = getIntent().getExtras().getString("score");
        name = getIntent().getExtras().getString("name");

        nameTextView.setText("Name : " + name);
        resultTextView.setText("Score : " + score);
    }
}