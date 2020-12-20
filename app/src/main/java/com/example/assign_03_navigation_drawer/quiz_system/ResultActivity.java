package com.example.assign_03_navigation_drawer.quiz_system;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.assign_03_navigation_drawer.CustomListAdapter;
import com.example.assign_03_navigation_drawer.R;
import com.example.assign_03_navigation_drawer.model.Question;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity
{
    private TextView resultTextView;
    private TextView nameTextView;
    private String score = "";
    private String name = "";
    private CustomListAdapter customListAdapter;
    private ListView listView;
    private List<Question> questionList;
    private int totalQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        getSupportActionBar().setTitle("Result");

        resultTextView = (TextView) findViewById(R.id.score_textView);
        nameTextView = (TextView) findViewById(R.id.name_textView);
        listView = (ListView) findViewById(R.id.ListView);

        score = getIntent().getExtras().getString("score");
        name = getIntent().getExtras().getString("name");
        totalQuestions = getIntent().getExtras().getInt("total");

        nameTextView.setText(name);
        resultTextView.setText("Score : " + score + "/" + totalQuestions);

        questionList = new ArrayList<>();

        questionList = (List<Question>) getIntent().getExtras().getSerializable("list");

        customListAdapter = new CustomListAdapter(this, R.layout.custom_list_item, questionList);
        listView.setAdapter(customListAdapter);
    }
}