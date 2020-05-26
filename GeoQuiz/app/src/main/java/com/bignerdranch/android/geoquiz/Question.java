package com.bignerdranch.android.geoquiz;

import androidx.annotation.StringRes;

public class Question {
    private @StringRes int questionId;
    private boolean isTrue;

    public Question(@StringRes int questionId, boolean isTrue) {
        this.questionId = questionId;
        this.isTrue = isTrue;
    }

    public @StringRes int getQuestionId(){
        return questionId;
    }

    public boolean getIsTrue(){
        return isTrue;
    }
}
