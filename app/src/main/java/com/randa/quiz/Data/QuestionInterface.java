package com.randa.quiz.Data;

import com.randa.quiz.POJO.QuestionModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface QuestionInterface {

    @GET("api/v1/questions")
    Call<List<QuestionModel>> getQuestions(@Query("apiKey") String apiKey,
                                           @Query("category") String category,
                                           @Query("difficulty")String difficulty,
                                           @Query("limit")String limit);
}
