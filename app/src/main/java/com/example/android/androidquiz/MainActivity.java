package com.example.android.androidquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


import static android.R.id.message;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.example.android.androidquiz.R.id.radioButton1;

public class MainActivity extends AppCompatActivity {

    String answerQuestion1 = "Pitcher";
    String answerQuestion3 = "First Baseman";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /* Check if the 1. answer is correct an deliver de right input for the summary */
    public String doCheckFirstQuestion() {
        EditText getUserInput = (EditText) findViewById(R.id.UserAnswer1);
        String answerText = getUserInput.getText().toString();
        if (answerText.equals(answerQuestion1)) {
            answerText = "Your answer was correct - Pitcher";
        } else {
            answerText = "Your answer was not correct. The correct answer is PITCHER";
        }
        return answerText;
    }
        /* Check if the 2. answer is correct an deliver de right input for the summary */
    public String doChecksecondQuestion() {
        String answerText = "";
        if (checkStatusCheckbox1()== true && checkStatusCheckbox2()== false && checkStatusCheckbox3()== true && checkStatusCheckbox4()== false) {
            answerText = "Your answer was correct - 1 and 3";
        } else {
            answerText = "Your answer was not correct. The correct answer is 1 AND 3";
        }
        return answerText;
    }
        /* Check if the 3 answer is correct an deliver de right input for the summary */
    public String doCheckthirdQuestion() {
        EditText getUserInput = (EditText) findViewById(R.id.UserAnswer3);
        String answerText = getUserInput.getText().toString();
        if (answerText.equals(answerQuestion3)) {
            answerText = "Your answer was correct - First Baseman";
        } else {
            answerText = "Your answer was not correct. The correct answer is FIRST BASEMAN";
        }
        return answerText;
    }
     /* Check if the 4. answer is correct an deliver de right input for the summary */
    public String doCheck4Question() {
        RadioButton Button  = (RadioButton) findViewById(R.id.radioButton1);
        String answerText = "";
        if (Button.isChecked()) {
            answerText = "Your answer was correct - Outfielder";
        } else {
            answerText = "Your answer was not correct. The correct answer is OUTFIELDER";
        }
        return answerText;

/* get triggert from the Submit Answers Button and calls the DisplayMessage Meth with the needed imput*/
    }
    public void submitAnswers(View view) {
        Toast.makeText(this, answerSummary(),Toast.LENGTH_LONG).show();
    }

/* Displays the text in the summary TextView */
    private void displayMessage(String message) {
        TextView summaryAnswers = (TextView) findViewById(R.id.summary);
        summaryAnswers.setText(message);
    }

/* Brings all the answers together in one text*/
    public String answerSummary() {
        String summany = getNameFromEditBox() + ", Thank you for playing the Game. Find below the answers:" + "\n\n" +
                doCheckFirstQuestion() + "\n\n" + doChecksecondQuestion() + "\n\n" + doCheckthirdQuestion()
                + "\n\n" + doCheck4Question();
        return summany;
    }

/* Read the User input */
    private String getNameFromEditBox() {
        EditText getName = (EditText) findViewById(R.id.NameText);
        String Name = getName.getText().toString();
        return Name;
    }

    /* Checks the status of the CheckBoxes */
    private boolean checkStatusCheckbox1() {
        CheckBox getStatus = (CheckBox) findViewById(R.id.checkBoxAnswer1);
        return (getStatus.isChecked());
    }
    private boolean checkStatusCheckbox2() {
        CheckBox getStatus = (CheckBox) findViewById(R.id.checkBoxAnswer2);
        return (getStatus.isChecked());
    }
    private boolean checkStatusCheckbox3() {
        CheckBox getStatus = (CheckBox) findViewById(R.id.checkBoxAnswer3);
        return (getStatus.isChecked());
    }
    private boolean checkStatusCheckbox4() {
        CheckBox getStatus = (CheckBox) findViewById(R.id.checkBoxAnswer3);
        return (getStatus.isChecked());
    }
}
