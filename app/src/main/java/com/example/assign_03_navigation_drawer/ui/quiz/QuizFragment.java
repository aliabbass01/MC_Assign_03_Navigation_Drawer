package com.example.assign_03_navigation_drawer.ui.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.assign_03_navigation_drawer.R;
import com.example.assign_03_navigation_drawer.quiz_system.QuestionsActivity;

public class QuizFragment extends Fragment
{

    private QuizViewModel quizViewModel;
    private EditText candidateName;
    private EditText noOfQuestions;
    private Button startQuizButton;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        quizViewModel =
                ViewModelProviders.of(this).get(QuizViewModel.class);
        View root = inflater.inflate(R.layout.fragment_quiz, container, false);

        candidateName = (EditText) root.findViewById(R.id.candidate_name);
        noOfQuestions = (EditText) root.findViewById(R.id.no_of_questions);
        startQuizButton = (Button) root.findViewById(R.id.start_quiz_button);

        startQuizButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                StartQuiz();
            }
        });

        return root;
    }

    private void StartQuiz()
    {
        String name = candidateName.getText().toString();
        String questionCount = noOfQuestions.getText().toString();

        if (name.isEmpty())
        {
            candidateName.setError("Please enter your name");
            candidateName.requestFocus();
        }
        else if (questionCount.isEmpty() || Integer.parseInt(questionCount) < 5  || Integer.parseInt(questionCount) > 10)
        {
            noOfQuestions.setError("Enter a number between 5 & 10");
            noOfQuestions.requestFocus();
        }
        else
        {
            Intent questionsIntent = new Intent(getActivity(), QuestionsActivity.class);
            questionsIntent.putExtra("name", name);
            questionsIntent.putExtra("count", questionCount);
            startActivity(questionsIntent);
        }
    }
}
