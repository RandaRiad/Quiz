package com.randa.quiz.POJO;

import android.nfc.Tag;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class QuestionModel implements Serializable, Parcelable {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("answers")
    @Expose
    private Answers answers;
    @SerializedName("multiple_correct_answers")
    @Expose
    private String multipleCorrectAnswers;
    @SerializedName("correct_answers")
    @Expose
    private CorrectAnswers correctAnswers;
    @SerializedName("correct_answer")
    @Expose
    private String correctAnswer;
    @SerializedName("explanation")
    @Expose
    private Object explanation;
    @SerializedName("tip")
    @Expose
    private Object tip;
    @SerializedName("tags")
    @Expose
    private List<Tag> tags = null;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("difficulty")
    @Expose
    private String difficulty;

    protected QuestionModel(Parcel in) {
        id = in.readInt();
        question = in.readString();
        multipleCorrectAnswers = in.readString();
        correctAnswer = in.readString();
        category = in.readString();
        difficulty = in.readString();
    }

    public static final Creator<QuestionModel> CREATOR = new Creator<QuestionModel>() {
        @Override
        public QuestionModel createFromParcel(Parcel in) {
            return new QuestionModel(in);
        }

        @Override
        public QuestionModel[] newArray(int size) {
            return new QuestionModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public Answers getAnswers() {
        return answers;
    }

    public CorrectAnswers getCorrectAnswers() {
        return correctAnswers;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDifficulty() {
        return difficulty;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(question);
        parcel.writeString(multipleCorrectAnswers);
        parcel.writeString(correctAnswer);
        parcel.writeString(category);
        parcel.writeString(difficulty);
    }
}
