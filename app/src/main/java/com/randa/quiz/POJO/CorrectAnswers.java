package com.randa.quiz.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CorrectAnswers implements Serializable {
    @SerializedName("answer_a_correct")
    @Expose
    private boolean answerACorrect;
    @SerializedName("answer_b_correct")
    @Expose
    private boolean answerBCorrect;
    @SerializedName("answer_c_correct")
    @Expose
    private boolean answerCCorrect;
    @SerializedName("answer_d_correct")
    @Expose
    private boolean answerDCorrect;
    @SerializedName("answer_e_correct")
    @Expose
    private boolean answerECorrect;
    @SerializedName("answer_f_correct")
    @Expose
    private boolean answerFCorrect;

    public boolean isAnswerACorrect() {
        return answerACorrect;
    }

    public boolean isAnswerBCorrect() {
        return answerBCorrect;
    }

    public boolean isAnswerCCorrect() {
        return answerCCorrect;
    }

    public boolean isAnswerDCorrect() {
        return answerDCorrect;
    }

    public boolean isAnswerECorrect() {
        return answerECorrect;
    }

    public boolean isAnswerFCorrect() {
        return answerFCorrect;
    }

}
