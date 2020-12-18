package com.example.assign_03_navigation_drawer.ui.quiz;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QuizViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public QuizViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
