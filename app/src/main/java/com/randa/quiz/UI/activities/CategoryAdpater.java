package com.randa.quiz.UI.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.randa.quiz.Data.Category;
import com.randa.quiz.R;
import com.randa.quiz.UI.ViewModelQuestions.ViewModelQuestion;

import java.util.ArrayList;

public class CategoryAdpater extends RecyclerView.Adapter<CategoryAdpater.CategoryViewHolder> {


    ArrayList<Category> category = new ArrayList<>();
    View view;
    Bundle bundle;

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cateogries, parent, false);

        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.categoryText.setText(category.get(position).getName());
        holder.imageView.setImageResource(category.get(position).getImageId());
        Intent intent = new Intent(view.getContext(), QuestionsActivity.class);

        holder.hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bundle = new Bundle();
                bundle.putString("diffculty", view.getResources().getString(R.string.Hard));
                bundle.putString("nameCategory", category.get(position).getName());
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);

            }
        });
        holder.medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bundle = new Bundle();
                bundle.putString("diffculty", view.getResources().getString(R.string.Medium));
                bundle.putString("nameCategory", category.get(position).getName());
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);

            }
        });
        holder.easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle = new Bundle();
                bundle.putString("diffculty", view.getResources().getString(R.string.Easy));
                bundle.putString("nameCategory", category.get(position).getName());
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);

            }
        });
        holder.arraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.diffculty.getVisibility() == View.VISIBLE) {

                    TransitionManager.beginDelayedTransition(holder.cardView,
                            new AutoTransition());
                    holder.diffculty.setVisibility(View.GONE);
                    holder.arraw.setImageResource(R.drawable.ic_baseline_expand_more_24);
                }

                // If the CardView is not expanded, set its visibility
                // to visible and change the expand more icon to expand less.
                else {

                    TransitionManager.beginDelayedTransition(holder.cardView,
                            new AutoTransition());
                    holder.diffculty.setVisibility(View.VISIBLE);
                    holder.arraw.setImageResource(R.drawable.ic_baseline_expand_less_24);
                }
            }

        });
    }

    public void setList(ArrayList<Category> category) {

        this.category = category;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView categoryText;
        Button easy, medium, hard;
        ImageView imageView, arraw;
        MaterialCardView cardView;
        LinearLayout diffculty;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryText = itemView.findViewById(R.id.name_category);
            easy = itemView.findViewById(R.id.easy_btn);
            medium = itemView.findViewById(R.id.medium_btn);
            hard = itemView.findViewById(R.id.hard_btn);
            imageView = itemView.findViewById(R.id.image_category);
            cardView = itemView.findViewById(R.id.category_cardview);
            diffculty = itemView.findViewById(R.id.diffculty_linear);
            arraw = itemView.findViewById(R.id.arraw_btn);


        }
    }
}
