package com.example.android.quizapp;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int score = 0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when the submit answers button is clicked.
     */
    public void submitScore(View view) {


        CheckBox question1ACheckbox = findViewById(R.id.question_one_barley);
        boolean question1Answer = question1ACheckbox.isChecked();

        CheckBox question1BCheckbox = findViewById(R.id.question_one_corn);
        boolean question1BAnswer = question1BCheckbox.isChecked();

        CheckBox question1CCheckbox = findViewById(R.id.question_one_wheat);
        boolean question1CAnswer = question1CCheckbox.isChecked();


        CheckBox question2ACheckbox = findViewById(R.id.question_two_barrels);
        boolean question2Answer = question2ACheckbox.isChecked();

        CheckBox question2BCheckbox = findViewById(R.id.question_two_white_oak);
        boolean question2BAnswer = question2BCheckbox.isChecked();

        CheckBox question2CCheckbox = findViewById(R.id.question_two_wax_bottles);
        boolean question2CAnswer = question2CCheckbox.isChecked();

        CheckBox question3ACheckbox = findViewById(R.id.question_three_makers);
        boolean question3Answer = question3ACheckbox.isChecked();

        CheckBox question3BCheckbox = findViewById(R.id.question_three_creek);
        boolean question3BAnswer = question3BCheckbox.isChecked();

        CheckBox question3CCheckbox = findViewById(R.id.question_hendricks);
        boolean question3CAnswer = question3CCheckbox.isChecked();


        boolean question4Answer = ((RadioButton) findViewById(R.id.geographic_radio_button)).isChecked();


        boolean question5Answer = ((RadioButton) findViewById(R.id.scotland_radio_button)).isChecked();


        boolean question6Answer = ((RadioButton) findViewById(R.id.tennessee_radio_button)).isChecked();


        /* Set the text in the edit text. */
        EditText question7Answer = findViewById(R.id.kentucky_field);
        String questionNumber7 = question7Answer.getText().toString();


        score = calculateScore(question1Answer, question1BAnswer, question1CAnswer, question2Answer,  question2BAnswer, question2CAnswer, question3Answer, question3BAnswer,
                question3CAnswer, question4Answer, question5Answer, question6Answer, questionNumber7  );


    }


    /**
     * Calculates the score based on the answers input from user
     *
     * @param question1Answer
     * @param question1BAnswer
     * @param question2Answer
     * @param question2BAnswer
     * @param question3Answer
     * @param question3BAnswer
     * @param geographic
     * @param scotland
     * @param tennessee
     * @param questionNumber7
     * @return
     */

    private int calculateScore(Boolean question1Answer, Boolean question1BAnswer, Boolean question1CAnswer, Boolean question2Answer, Boolean question2BAnswer, Boolean question2CAnswer, Boolean question3Answer, Boolean question3BAnswer, Boolean question3CAnswer, Boolean geographic, Boolean scotland,
                               Boolean tennessee, String questionNumber7) {
        int score = 0;




        if (question1Answer == true && question1BAnswer == true && !question1CAnswer) {
            score += 1;
        }

        if (question2Answer == true && question2BAnswer == true && !question2CAnswer) {
            score += 1;
        }

        if (question3Answer == true && question3BAnswer == true && !question3CAnswer) {
            score += 1;
        }

        if (geographic == true) {
            score += 1;
        }

        if (scotland == true) {
            score += 1;
        }

        if (tennessee == true) {
            score += 1;
        }

        if (questionNumber7.equalsIgnoreCase("kentucky")) {
                score += 1;

        }

        if (score > 4) {
            Toast.makeText(getApplicationContext(), "You scored " + score + " out of 7 Points. " + "Cheers, you have Whiskey Knowledge!", Toast.LENGTH_LONG).show();
        } else if (score < 4) {
            Toast.makeText(getApplicationContext(), "You scored " + score + " out of 7 Points. " + "Not enough Whiskey Knowledge. ", Toast.LENGTH_LONG).show();
        }

        return score;

    }


}


