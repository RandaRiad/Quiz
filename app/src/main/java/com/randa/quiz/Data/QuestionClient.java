package com.randa.quiz.Data;

import com.randa.quiz.POJO.QuestionModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuestionClient {


    private QuestionInterface questionInterface;
    private static  QuestionClient INSTANCE ;

    public QuestionClient() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(new Credentials().getBASE_URL())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        questionInterface=retrofit.create(QuestionInterface.class);
    }



    public static QuestionClient getINSTANCE() {
        if(INSTANCE==null){
            INSTANCE=new QuestionClient();
        }
        return INSTANCE;
    }

    public Call<List<QuestionModel>> getQuestionsAll(String apiKey, String category, String diffcilty, String limit){
        return questionInterface.getQuestions(apiKey,category,diffcilty,limit);

    }
}
