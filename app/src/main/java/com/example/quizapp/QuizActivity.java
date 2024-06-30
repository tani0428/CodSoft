package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private Button submitAnswerButton;

    private int currentQuestionIndex = 0;
    private int score = 0;

    private String[] questions = {
            "Which planet in the Solar System is the smallest?",
            "What is the capital of France?",
            "Who wrote 'To Kill a Mockingbird'?",
            "What is the largest mammal in the world?",
            "What is the square root of 64?",
            "What is the chemical symbol for water?",
            "Who painted the Mona Lisa?",
            "What is the longest river in the world?",
            "What is the primary language spoken in Brazil?",
            "Which element has the atomic number 1?"
    };

    private String[][] options = {
            {"Pluto", "Earth", "Mercury", "Mars"},
            {"Berlin", "Madrid", "Paris", "Rome"},
            {"Harper Lee", "J.K. Rowling", "Mark Twain", "Ernest Hemingway"},
            {"Blue Whale", "Elephant", "Giraffe", "Hippopotamus"},
            {"6", "7", "8", "9"},
            {"O", "H2O", "CO2", "HO"},
            {"Leonardo da Vinci", "Pablo Picasso", "Vincent van Gogh", "Claude Monet"},
            {"Amazon", "Nile", "Yangtze", "Mississippi"},
            {"Spanish", "Portuguese", "English", "French"},
            {"Hydrogen", "Helium", "Lithium", "Carbon"}
    };

    private int[] correctAnswers = {
            2, // Mercury
            2, // Paris
            0, // Harper Lee
            0, // Blue Whale
            2, // 8
            1, // H2O
            0, // Leonardo da Vinci
            1, // Nile
            1, // Portuguese
            0  // Hydrogen
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionTextView = findViewById(R.id.questionTextView);
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        submitAnswerButton = findViewById(R.id.submitAnswerButton);

        loadQuestion();

        submitAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedOptionIndex = optionsRadioGroup.indexOfChild(findViewById(optionsRadioGroup.getCheckedRadioButtonId()));

                if (selectedOptionIndex == correctAnswers[currentQuestionIndex]) {
                    score++;
                }

                currentQuestionIndex++;

                if (currentQuestionIndex < questions.length) {
                    loadQuestion();
                } else {
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    intent.putExtra("score", score);
                    intent.putExtra("totalQuestions", questions.length);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void loadQuestion() {
        questionTextView.setText(questions[currentQuestionIndex]);
        ((RadioButton) optionsRadioGroup.getChildAt(0)).setText(options[currentQuestionIndex][0]);
        ((RadioButton) optionsRadioGroup.getChildAt(1)).setText(options[currentQuestionIndex][1]);
        ((RadioButton) optionsRadioGroup.getChildAt(2)).setText(options[currentQuestionIndex][2]);
        ((RadioButton) optionsRadioGroup.getChildAt(3)).setText(options[currentQuestionIndex][3]);
        optionsRadioGroup.clearCheck();
    }
}
