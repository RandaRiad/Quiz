package com.randa.quiz.POJO;

import android.os.Parcel;
import android.os.Parcelable;

public class YourAnswers implements Parcelable {

    private boolean yourAnswerA;
    private boolean yourAnswerB;
    private boolean yourAnswerC;
    private boolean yourAnswerD;
    private boolean yourAnswerE;
    private boolean yourAnswerF;


    public boolean getYourAnswerA() {
        return yourAnswerA;
    }

    public void setYourAnswerA(boolean yourAnswerA) {
        this.yourAnswerA = yourAnswerA;
    }

    public boolean getYourAnswerB() {
        return yourAnswerB;
    }

    public void setYourAnswerB(boolean yourAnswerB) {
        this.yourAnswerB = yourAnswerB;
    }

    public boolean getYourAnswerC() {
        return yourAnswerC;
    }

    public void setYourAnswerC(boolean yourAnswerC) {
        this.yourAnswerC = yourAnswerC;
    }

    public boolean getYourAnswerD() {
        return yourAnswerD;
    }

    public void setYourAnswerD(boolean yourAnswerD) {
        this.yourAnswerD = yourAnswerD;
    }

    public boolean getYourAnswerE() {
        return yourAnswerE;
    }

    public void setYourAnswerE(boolean yourAnswerE) {
        this.yourAnswerE = yourAnswerE;
    }

    public boolean getYourAnswerF() {
        return yourAnswerF;
    }

    public void setYourAnswerF(boolean yourAnswerF) {
        this.yourAnswerF = yourAnswerF;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
