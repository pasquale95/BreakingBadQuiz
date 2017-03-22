package com.example.android.quiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int correct_ans=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void first_answ(){
        EditText firstAnsw = (EditText) findViewById(R.id.first_edit);
        String answer = firstAnsw.getText().toString();
        if(answer.equals("Walter"))
            correct_ans++;
    }

    private void two_answ() {
        RadioButton secAnsw = (RadioButton) findViewById(R.id.two_two);
        if(secAnsw.isChecked())
            correct_ans++;
    }

    private void three_answ() {
        RadioButton threeAnsw = (RadioButton) findViewById(R.id.three_two);
        if(threeAnsw.isChecked())
            correct_ans++;
    }

    private void four_answ(){
        boolean one, two, three, four;
        CheckBox fourAnsw = (CheckBox) findViewById(R.id.four_one);
        one = fourAnsw.isChecked();
        fourAnsw = (CheckBox) findViewById(R.id.four_two);
        two = fourAnsw.isChecked();
        fourAnsw = (CheckBox) findViewById(R.id.four_three);
        three = fourAnsw.isChecked();
        fourAnsw = (CheckBox) findViewById(R.id.four_four);
        four = fourAnsw.isChecked();
        if(one && three && !two && !four)
            correct_ans++;
    }

    private void five_answ() {
        RadioButton threeAnsw = (RadioButton) findViewById(R.id.five_one);
        if(threeAnsw.isChecked())
            correct_ans++;
    }

    private void six_answ(){
        boolean one, two, three, four;
        CheckBox fourAnsw = (CheckBox) findViewById(R.id.six_one);
        one = fourAnsw.isChecked();
        fourAnsw = (CheckBox) findViewById(R.id.six_two);
        two = fourAnsw.isChecked();
        fourAnsw = (CheckBox) findViewById(R.id.six_three);
        three = fourAnsw.isChecked();
        fourAnsw = (CheckBox) findViewById(R.id.six_four);
        four = fourAnsw.isChecked();
        if(!one && three && two && !four)
            correct_ans++;
    }

    private void seven_answ() {
        RadioButton threeAnsw = (RadioButton) findViewById(R.id.seven_one);
        if(threeAnsw.isChecked())
            correct_ans++;
    }

    private void eight_answ() {
        RadioButton threeAnsw = (RadioButton) findViewById(R.id.eight_two);
        if(threeAnsw.isChecked())
            correct_ans++;
    }

    private void nine_answ() {
        RadioButton threeAnsw = (RadioButton) findViewById(R.id.nine_one);
        if(threeAnsw.isChecked())
            correct_ans++;
    }

    private void ten_answ() {
        RadioButton threeAnsw = (RadioButton) findViewById(R.id.ten_one);
        if(threeAnsw.isChecked())
            correct_ans++;
    }

    public void calculatePoints(){
        first_answ();
        two_answ();
        three_answ();
        four_answ();
        five_answ();
        six_answ();
        seven_answ();
        eight_answ();
        nine_answ();
        ten_answ();
    }

    public void submitAnswer(View view){
        String mex;
        calculatePoints();
        if(correct_ans >= 0 && correct_ans < 6)
            mex = getString(R.string.correct_ans)+correct_ans+getString(R.string.less_six);
        else
            mex = getString(R.string.correct_ans)+correct_ans+getString(R.string.equal_six);
        Toast.makeText(this, mex, Toast.LENGTH_LONG).show();
        correct_ans=0;
    }

    public void reset(View view){
        EditText firstAnsw = (EditText) findViewById(R.id.first_edit);
        RadioGroup secAnsw = (RadioGroup) findViewById(R.id.two);
        RadioGroup threeAnsw = (RadioGroup) findViewById(R.id.three);
        CheckBox fourAnsw = (CheckBox) findViewById(R.id.four_one);
        RadioGroup fiveAnsw = (RadioGroup) findViewById(R.id.five);
        CheckBox sixAnsw = (CheckBox) findViewById(R.id.six_one);
        RadioGroup sevenAnsw = (RadioGroup) findViewById(R.id.seven);
        RadioGroup eightAnsw = (RadioGroup) findViewById(R.id.eight);
        RadioGroup nineAnsw = (RadioGroup) findViewById(R.id.nine);
        RadioGroup tenAnsw = (RadioGroup) findViewById(R.id.ten);

        firstAnsw.setText("");
        secAnsw.clearCheck();
        threeAnsw.clearCheck();
        fourAnsw.setChecked(false);
        fourAnsw = (CheckBox) findViewById(R.id.four_two);
        fourAnsw.setChecked(false);
        fourAnsw = (CheckBox) findViewById(R.id.four_three);
        fourAnsw.setChecked(false);
        fourAnsw = (CheckBox) findViewById(R.id.four_four);
        fourAnsw.setChecked(false);
        fiveAnsw.clearCheck();
        sixAnsw.setChecked(false);
        sixAnsw = (CheckBox) findViewById(R.id.six_two);
        sixAnsw.setChecked(false);
        sixAnsw = (CheckBox) findViewById(R.id.six_three);
        sixAnsw.setChecked(false);
        sixAnsw = (CheckBox) findViewById(R.id.six_four);
        sixAnsw.setChecked(false);
        sevenAnsw.clearCheck();
        eightAnsw.clearCheck();
        nineAnsw.clearCheck();
        tenAnsw.clearCheck();
    }

    public void mail(View view){
        String subject = getString(R.string.feedback).toString();
        String[] addresses = {getString(R.string.mail1).toString()};
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
