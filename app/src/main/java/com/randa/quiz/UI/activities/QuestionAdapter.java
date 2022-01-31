package com.randa.quiz.UI.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.randa.quiz.POJO.QuestionModel;
import com.randa.quiz.POJO.YourAnswers;
import com.randa.quiz.R;

import java.util.ArrayList;
import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {
    View view;
    List<QuestionModel> questions = new ArrayList();
    List<YourAnswers> userAnswe = new ArrayList<>();

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_item, parent, false);

        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {

        holder.questionText.setText(questions.get(position).getQuestion());

        checkedAnswer(questions.get(position).getAnswers().getAnswerA(), holder.a);
        setCheckedBox(userAnswe.get(position).getYourAnswerA(), holder.a);
        correctAnswer(holder.a, questions.get(position).getCorrectAnswers().isAnswerACorrect());

        checkedAnswer(questions.get(position).getAnswers().getAnswerB(), holder.b);
        setCheckedBox(userAnswe.get(position).getYourAnswerB(), holder.b);
        correctAnswer(holder.b, questions.get(position).getCorrectAnswers().isAnswerBCorrect());

        checkedAnswer(questions.get(position).getAnswers().getAnswerC(), holder.c);
        setCheckedBox(userAnswe.get(position).getYourAnswerC(), holder.c);
        correctAnswer(holder.c, questions.get(position).getCorrectAnswers().isAnswerCCorrect());

        checkedAnswer(questions.get(position).getAnswers().getAnswerD(), holder.d);
        setCheckedBox(userAnswe.get(position).getYourAnswerD(), holder.d);
        correctAnswer(holder.d, questions.get(position).getCorrectAnswers().isAnswerDCorrect());

        checkedAnswer(questions.get(position).getAnswers().getAnswerE(), holder.e);
        setCheckedBox(userAnswe.get(position).getYourAnswerE(), holder.e);
        ;
        correctAnswer(holder.e, questions.get(position).getCorrectAnswers().isAnswerECorrect());

        checkedAnswer(questions.get(position).getAnswers().getAnswerF(), holder.f);
        setCheckedBox(userAnswe.get(position).getYourAnswerF(), holder.f);
        correctAnswer(holder.f, questions.get(position).getCorrectAnswers().isAnswerFCorrect());


    }

    private void setCheckedBox(boolean checked, CheckBox checkBox) {

        if (checked) {
            checkBox.setChecked(true);
        } else {
            checkBox.setChecked(false);
        }
    }

    //check checkbox is null so invisible it from screen
    private void checkedAnswer(String text, CheckBox checkBox) {

        if (text != null) {
            checkBox.setVisibility(View.VISIBLE);
            checkBox.setText(text);

        } else {
            checkBox.setVisibility(View.GONE);

        }

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    private void correctAnswer(CheckBox checkBoxe, boolean check) {
        if (check == true) {
            checkBoxe.setBackgroundColor(Color.GREEN);
        } else {
            checkBoxe.setBackgroundColor(view.getResources().getColor(R.color.gray));

        }
    }


    public void setList(List<QuestionModel> questions) {
        this.questions = questions;
        notifyDataSetChanged();


    }

    public void getYouranswers(List<YourAnswers> answers) {
        this.userAnswe = answers;
        notifyDataSetChanged();


    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class QuestionViewHolder extends RecyclerView.ViewHolder {
        TextView questionText, result;
        CheckBox a, b, c, d, e, f;

        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            questionText = itemView.findViewById(R.id.questio_text);
            a = itemView.findViewById(R.id.checked_a);
            b = itemView.findViewById(R.id.checked_b);
            c = itemView.findViewById(R.id.checked_c);
            d = itemView.findViewById(R.id.checked_d);
            e = itemView.findViewById(R.id.checked_e);
            f = itemView.findViewById(R.id.checked_f);

        }
    }
}
