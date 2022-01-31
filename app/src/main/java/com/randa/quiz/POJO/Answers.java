package com.randa.quiz.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Answers implements Serializable {


    @SerializedName("answer_a")
    @Expose
    private String answerA;
    @SerializedName("answer_b")
    @Expose
    private String answerB;
    @SerializedName("answer_c")
    @Expose
    private String answerC;
    @SerializedName("answer_d")
    @Expose
    private String answerD;
    @SerializedName("answer_e")
    @Expose
    private String answerE;
    @SerializedName("answer_f")
    @Expose
    private String answerF;

    public Answers() {
    }

    public String getAnswerA() {
        return answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public String getAnswerE() {
        return answerE;
    }

    public String getAnswerF() {
        return answerF;
    }

}
