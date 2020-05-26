package com.bignerdranch.android.geoquiz;

import java.util.ArrayList;
import java.util.List;

public class QuizManager {
    private List<Question> questions = new ArrayList<>();
    private int index = 0;

    public QuizManager(){
        questions.add(new Question(R.string.question_1, false));
        questions.add(new Question(R.string.question_2, true));
        questions.add(new Question(R.string.question_3, true));
        questions.add(new Question(R.string.question_4, false));
    }

    public Question getCurrentQuestion() {
        return questions.get(index);
    }

    public boolean prevQuestion() {
        if (index > 0) {
            index--;
            return true;
        } else {
            return false;
        }
    }

    public boolean nextQuestion() {
        if (index < questions.size()-1) {
            index++;
            return true;
        } else {
            return false;
        }
    }
}
