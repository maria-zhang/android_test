package com.bignerdranch.android.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button trueButton;
    private Button falseButton;
    private Button prevButton;
    private Button nextButton;
    private Button cheatButton;
    private TextView question;
    private QuizManager manager = new QuizManager();
    private Toast currToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);
        prevButton = findViewById(R.id.prevButton);
        nextButton = findViewById(R.id.nextButton);
        cheatButton = findViewById(R.id.cheatButton);

        question = findViewById(R.id.questionTextView);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currToast != null) {
                    currToast.cancel();
                }

                if (manager.getCurrentQuestion().getIsTrue()) {
                    currToast = Toast.makeText(QuizActivity.this, R.string.correct_popup, Toast.LENGTH_LONG);
                } else {
                    currToast = Toast.makeText(QuizActivity.this, R.string.incorrect_popup, Toast.LENGTH_LONG);
                }
                currToast.show();
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currToast != null) {
                    currToast.cancel();
                }
                if (!manager.getCurrentQuestion().getIsTrue()) {
                    currToast = Toast.makeText(QuizActivity.this, R.string.correct_popup, Toast.LENGTH_LONG);
                } else {
                    currToast = Toast.makeText(QuizActivity.this, R.string.incorrect_popup, Toast.LENGTH_LONG);
                }
                currToast.show();
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (manager.prevQuestion()) {
                    update();
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (manager.nextQuestion()) {
                    update();
                }
            }
        });

        cheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cheatIntent = new Intent(QuizActivity.this, CheatActivity.class);
                cheatIntent.putExtra("question", manager.getCurrentQuestion().getQuestionId());
                cheatIntent.putExtra("answer", manager.getCurrentQuestion().getIsTrue());
                startActivity(cheatIntent);
            }
        });

        update();
    }
    private void update() {
        question.setText(manager.getCurrentQuestion().getQuestionId());
    }
}
