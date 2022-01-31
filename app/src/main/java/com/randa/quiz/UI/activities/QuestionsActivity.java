package com.randa.quiz.UI.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.randa.quiz.R;
import com.randa.quiz.UI.Fragments.QuestionsFragments;
import com.randa.quiz.UI.Fragments.ResultFragments;
import com.randa.quiz.UI.ViewModelQuestions.ViewModelQuestion;
import com.randa.quiz.databinding.ActivityQuestionsBinding;

public class QuestionsActivity extends AppCompatActivity {

    ActivityQuestionsBinding binding;
    QuestionsFragments questionsFragments;
    Bundle bundle, data;
    ResultFragments resultFragments;
    ViewModelQuestion viewModelQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        questionsFragments = new QuestionsFragments();
        currentFragment(questionsFragments);
        bundle = getIntent().getExtras();
        data = new Bundle();
        data.putString("category", bundle.getString("nameCategory"));
        data.putString("Diffcult", bundle.getString("diffculty"));
        questionsFragments.setArguments(data);


    }


    public void currentFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, fragment).commit();
    }
}