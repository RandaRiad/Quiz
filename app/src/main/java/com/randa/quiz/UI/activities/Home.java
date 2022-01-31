package com.randa.quiz.UI.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.randa.quiz.Data.Category;
import com.randa.quiz.R;
import com.randa.quiz.UI.activities.CategoryAdpater;
import com.randa.quiz.databinding.ActivityHomeBinding;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    //  String[] category;
    ActivityHomeBinding binding;
    CategoryAdpater adapter;
    ArrayList<Category> category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        adapter = new CategoryAdpater();


        binding.categoryRecycler.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));

        adapter.setList(addCategory());

        binding.categoryRecycler.setAdapter(adapter);


    }

    public ArrayList<Category> addCategory() {

        category = new ArrayList<>();
        category.add(new Category("Linux", R.drawable.linux));
        category.add(new Category("SQL", R.drawable.sql));
        category.add(new Category("Code", R.drawable.code));
        category.add(new Category("Docker", R.drawable.docker1));
        category.add(new Category("DevOps", R.drawable.devops2));
        category.add(new Category("Bash", R.drawable.bash));


        return category;

    }
}