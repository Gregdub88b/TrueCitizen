package com.example.truecitizen;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.truecitizen.databinding.ActivityMainBinding;
import com.example.truecitizen.model.Questions;
import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private int currentQuestionIndex = 0;

    private Questions[] questionsBank = new Questions[]{
            //create instantiate question objets

            new Questions(R.string.question_amendments, false),
            new Questions(R.string.question_constitution, true),
            new Questions(R.string.question_declaration, true),
            new Questions(R.string.question_independence_rights, true),
            new Questions(R.string.question_government, false),
            new Questions(R.string.question_government_feds, false),
            new Questions(R.string.question_government_senators, true),


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        binding.questionTextView.setText(questionsBank[currentQuestionIndex].getAnswwerResId());

        binding.trueButton.setOnClickListener(view -> {

            checkAnswer(true);
        });
        binding.falseButton.setOnClickListener(view -> {

            checkAnswer(false);
        });
        binding.button4.setOnClickListener(view -> {

            Log.d("Main", "onCreate: " + questionsBank[currentQuestionIndex++]);
            currentQuestionIndex = (currentQuestionIndex + 1) % questionsBank.length;
            updateQuestion();
        });
        binding.button3.setOnClickListener(view -> {
            if (currentQuestionIndex > 0) {
                currentQuestionIndex = (currentQuestionIndex - 1) % questionsBank.length;
                updateQuestion();
            }
        });
    
    }

    private void checkAnswer(boolean userChooseCorrect) {

        boolean answerIsCorrect = questionsBank[currentQuestionIndex].isAnswerTrue();
        int messageId;

        if (answerIsCorrect == userChooseCorrect) {
            messageId = R.string.correct_answer;
        }else{

            messageId = R.string.wrong_answer;
        }

        Snackbar.make(binding.imageView,messageId,Snackbar.LENGTH_SHORT).show();

    }


    private void updateQuestion() {

        binding.questionTextView.setText(questionsBank[currentQuestionIndex].getAnswwerResId());
    }
}