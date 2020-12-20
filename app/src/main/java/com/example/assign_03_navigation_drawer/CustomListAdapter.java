package com.example.assign_03_navigation_drawer;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.assign_03_navigation_drawer.model.Question;

import java.util.List;

public class CustomListAdapter extends ArrayAdapter<Question>
{
    Context context;
    LayoutInflater layoutInflater;
    List<Question> questions;

    public CustomListAdapter(Context context, int resource, List<Question> questionList)
    {
        super(context, resource, questionList);
        this.context = context;
        this.questions = questionList;
        layoutInflater = LayoutInflater.from(context);
    }

    private class ViewHolder
    {
        TextView questionTxt;
        RadioButton rb1, rb2, rb3, rb4;
        RadioGroup rg;
    }

    public View getView(int position, View view, ViewGroup parent)
    {
        final ViewHolder holder;
        if (view == null)
        {
            holder = new ViewHolder();
            view = layoutInflater.inflate(R.layout.custom_list_item, null);
            holder.questionTxt = (TextView) view.findViewById(R.id.questionTxt);
            holder.rb1 = (RadioButton) view.findViewById(R.id.option_1_item);
            holder.rb2 = (RadioButton) view.findViewById(R.id.option_2_item);
            holder.rb3 = (RadioButton) view.findViewById(R.id.option_3_item);
            holder.rb4 = (RadioButton) view.findViewById(R.id.option_4_item);
            holder.rg = (RadioGroup) view.findViewById(R.id.radio_group_item);
            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }

        holder.rb1.setTextColor(Color.RED);
        holder.rb2.setTextColor(Color.RED);
        holder.rb3.setTextColor(Color.RED);
        holder.rb4.setTextColor(Color.RED);

        Question question = questions.get(position);
        holder.questionTxt.setText(question.getQuestion());
        holder.rb1.setText(question.getOption1());
        holder.rb2.setText(question.getOption2());
        holder.rb3.setText(question.getOption3());
        holder.rb4.setText(question.getOption4());

        switch (question.getAnswerNum())
        {
            case 1:
                holder.rb1.setTextColor(Color.GREEN);
                break;
            case 2:
                holder.rb2.setTextColor(Color.GREEN);
                break;
            case 3:
                holder.rb3.setTextColor(Color.GREEN);
                break;
            case 4:
                holder.rb4.setTextColor(Color.GREEN);
                break;
        }

        // Capture position and set to the ImageView
        return view;
    }
}
