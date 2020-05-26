package com.bignerdranch.android.geoquiz;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private TextView questionText;
    private TextView answerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        @StringRes int questionId = getIntent().getIntExtra("question", 0);
        boolean answer = getIntent().getBooleanExtra("answer", false);

        questionText = findViewById(R.id.cheatQuestion);
        answerText = findViewById(R.id.cheatAnswer);

        questionText.setText(questionId);
        answerText.setText(Boolean.toString(answer));
    }
}
