package com.randa.quiz.UI.ViewModelQuestions;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.randa.quiz.Data.Credentials;
import com.randa.quiz.Data.QuestionClient;
import com.randa.quiz.POJO.QuestionModel;
import com.randa.quiz.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelQuestion extends ViewModel {

    private MutableLiveData<List<QuestionModel>> questionModelMutableLiveData = new MutableLiveData<>();
    private Credentials credentials;
    private final String LIMIT = "20";

    public MutableLiveData<List<QuestionModel>> getQuestionModelMutableLiveData() {
        return questionModelMutableLiveData;
    }

    public void setQuestionModelMutableLiveData(List<QuestionModel> questionModelMutableLiveData) {
        this.questionModelMutableLiveData.setValue(questionModelMutableLiveData);
    }

    private MutableLiveData<List<QuestionModel>> listQuestion = new MutableLiveData<>();


    public MutableLiveData<List<QuestionModel>> getListQuestion() {
        return listQuestion;
    }

    public void setListQuestion(List<QuestionModel> listQuestion) {
        this.listQuestion.setValue(listQuestion);

    }

    public void getQuestions(String categoryName, String diffculty) {
        credentials = new Credentials();

        Call<List<QuestionModel>> model = QuestionClient.getINSTANCE().getQuestionsAll(credentials.getKEY(), categoryName, diffculty, LIMIT);
        model.enqueue(new Callback<List<QuestionModel>>() {
            @Override
            public void onResponse(Call<List<QuestionModel>> call, Response<List<QuestionModel>> response) {

                setListQuestion(response.body());
                setQuestionModelMutableLiveData(response.body());
            }

            @Override
            public void onFailure(Call<List<QuestionModel>> call, Throwable t) {

            }
        });
    }


}
