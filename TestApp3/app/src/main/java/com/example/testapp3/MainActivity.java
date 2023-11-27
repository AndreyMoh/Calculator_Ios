package com.example.testapp3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView resTextView;
    private float a;
    private float b;
    private float res;

    private float numb = 0;

    private boolean isActionClicked;
    Action action = Action.NULLACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         resTextView = findViewById(R.id.res_textview);

        final Button one_sign_button = findViewById(R.id.one_sign_button);
        final Button two_sign_button = findViewById(R.id.two_sign_button);
        final Button three_sign_button = findViewById(R.id.three_sign_button);
        final Button fore_sign_button = findViewById(R.id.fore_sign_button);
        final Button five_sign_button = findViewById(R.id.five_sign_button);
        final Button six_sign_button = findViewById(R.id.six_sign_button);
        final Button seven_sign_button = findViewById(R.id.seven_sign_button);
        final Button eight_sign_button = findViewById(R.id.eight_sign_button);
        final Button nine_sign_button = findViewById(R.id.nine_sign_button);
        final Button zero_sign_button = findViewById(R.id.zero_sign_button);

        final Button subtract_button = findViewById(R.id.subtract_button);
        final Button sum_button = findViewById(R.id.sum_button);
        final Button multiple_sign_button = findViewById(R.id.multiple_button);
        final Button divide_button = findViewById(R.id.divide_button);
        final Button plus_minus_button = findViewById(R.id.plus_minus_button);
        final Button percent_button = findViewById(R.id.percent_button);
        final Button dot_button = findViewById(R.id.dot_button);
        final Button delete_res_button = findViewById(R.id.delete_res_button);
        final Button equal_button = findViewById(R.id.equal_button);

        one_sign_button.setOnClickListener(this);
        two_sign_button.setOnClickListener(this);
        three_sign_button.setOnClickListener(this);
        fore_sign_button.setOnClickListener(this);
        five_sign_button.setOnClickListener(this);
        six_sign_button.setOnClickListener(this);
        seven_sign_button.setOnClickListener(this);
        eight_sign_button.setOnClickListener(this);
        nine_sign_button.setOnClickListener(this);
        zero_sign_button.setOnClickListener(this);

        subtract_button.setOnClickListener(this);
        sum_button.setOnClickListener(this);
        multiple_sign_button.setOnClickListener(this);
        divide_button.setOnClickListener(this);
        plus_minus_button.setOnClickListener(this);
        percent_button.setOnClickListener(this);
        dot_button.setOnClickListener(this);
        delete_res_button.setOnClickListener(this);
        equal_button.setOnClickListener(this);

        a = 0;
        b = 0;
        res = 0;
        isActionClicked = false;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.one_sign_button) {
            resTextView.setText(R.string.one_sign);
            numb = 1;
        } else if (v.getId() == R.id.two_sign_button) {
            resTextView.setText(R.string.two_sign);
            numb = 2;
        } else if (v.getId() == R.id.three_sign_button) {
            resTextView.setText(R.string.three_sign);
            numb = 3;
        } else if (v.getId() == R.id.fore_sign_button) {
            resTextView.setText(R.string.fore_sign);
            numb = 4;
        } else if (v.getId() == R.id.five_sign_button) {
            resTextView.setText(R.string.five_sign);
            numb = 5;
        } else if (v.getId() == R.id.six_sign_button) {
            resTextView.setText(R.string.six_sign);
            numb = 6;
        } else if (v.getId() == R.id.seven_sign_button) {
            resTextView.setText(R.string.seven_sign);
            numb = 7;
        } else if (v.getId() == R.id.eight_sign_button) {
            resTextView.setText(R.string.eight_sign);
            numb = 8;
        } else if (v.getId() == R.id.nine_sign_button) {
            resTextView.setText(R.string.nine_sign);
            numb = 9;
        } else if (v.getId() == R.id.zero_sign_button) {
            resTextView.setText(R.string.zero_sign);
            numb = 0;
        } else if (v.getId() == R.id.subtract_button) {
            isActionClicked = true;
            action = Action.SUBTRACT;
        } else if (v.getId() == R.id.divide_button) {
            isActionClicked = true;
            action = Action.DIVIDE;
        } else if (v.getId() == R.id.multiple_button) {
            isActionClicked = true;
            action = Action.MULTIPLE;
        } else if (v.getId() == R.id.sum_button) {
            isActionClicked = true;
            action = Action.SUM;
        } else if (v.getId() == R.id.percent_button) {
            action = Action.PERCENT;
            numb *= 0.01;
            resTextView.setText("" + numb);
        } else if (v.getId() == R.id.dot_button) {
            isActionClicked = true;
            action = Action.DOTFUNC;
        } else if (v.getId() == R.id.plus_minus_button) {
            action = Action.PLUS_MINUS;
            numb *= -1;
            resTextView.setText("" + numb);
        } else if (v.getId() == R.id.equal_button) {
            equal(action);
        } else if (v.getId() == R.id.delete_res_button) {
            resTextView.setText(R.string.zero_sign);
            action = Action.NULLACTION;
            isActionClicked = false;
            a = 0;
            b = 0;
            res = 0;
        }

        if (!isActionClicked) a = numb;
        else b = numb;
        Toast.makeText(getApplicationContext(), "a, b = " + a + " " + b, Toast.LENGTH_SHORT).show();
    }

    private enum Action {
        SUBTRACT,
        SUM,
        DIVIDE,
        MULTIPLE,
        PERCENT,
        DOTFUNC,
        PLUS_MINUS,
        NULLACTION
    }

    private float subtract(float a, float b) { return (float) a - b; }

    private float sum(float a, float b) { return (float) a + b; }

    private float divide(float a, float b) { return (float) a / b; }

    private float multiple(float a, float b) { return (float) a * b; }

    private void equal(Action action) {
        switch (action) {
            case SUBTRACT:
                res = subtract(a, b);
                break;
            case SUM:
                res = sum(a, b);
                break;
            case DIVIDE:
                res = divide(a, b);
                break;
            case MULTIPLE:
                res = multiple(a, b);
                break;
            case NULLACTION:
                break;
        }
        resTextView.setText("" + res);
    }
}