package com.example.testapp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView resTextView;
    private float a;
    private float b;
    private float res;

    private String numb = "";

    private boolean isActionClicked;
    Action action = Action.NULLACTION;

    private GestureDetectorCompat lSwipeDetector;
    private static final int SWIPE_MIN_DISTANCE = 15;
    private static final int SWIPE_MAX_DISTANCE = 1000;
    private static final int SWIPE_MIN_VELOCITY = 200;

    private Button subtract_button, sum_button, multiple_sign_button, divide_button;

    // Colors
    private int colorWhite;
    private int colorOrange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resTextView = findViewById(R.id.res_textview);
        {
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

            subtract_button = findViewById(R.id.subtract_button);
            sum_button = findViewById(R.id.sum_button);
            multiple_sign_button = findViewById(R.id.multiple_button);
            divide_button = findViewById(R.id.divide_button);
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
        }
        lSwipeDetector = new GestureDetectorCompat(this, new MainActivity.MyGestureListener());

        a = 0;
        b = 0;
        res = 0;
        isActionClicked = false;

        resTextView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return lSwipeDetector.onTouchEvent(event);
            }
        });

        colorWhite = getResources().getColor(R.color.white,  null);
        colorOrange = getResources().getColor(R.color.orange,  null);
    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_DISTANCE)
                return false;
            if (Math.abs(e2.getX() - e1.getX()) > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_MIN_VELOCITY) {
                if (!Objects.equals(numb, "")) {
                    numb = String.valueOf(resTextView.getText()).substring(0, String.valueOf(resTextView.getText()).length() - 1);
                }
                resTextView.setText(numb);
            }
            return false;
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.one_sign_button) {
            addSymbol("1");
        } else if (v.getId() == R.id.two_sign_button) {
            addSymbol("2");
        } else if (v.getId() == R.id.three_sign_button) {
            addSymbol("3");
        } else if (v.getId() == R.id.fore_sign_button) {
            addSymbol("4");
        } else if (v.getId() == R.id.five_sign_button) {
            addSymbol("5");
        } else if (v.getId() == R.id.six_sign_button) {
            addSymbol("6");
        } else if (v.getId() == R.id.seven_sign_button) {
            addSymbol("7");
        } else if (v.getId() == R.id.eight_sign_button) {
            addSymbol("8");
        } else if (v.getId() == R.id.nine_sign_button) {
            addSymbol("9");
        } else if (v.getId() == R.id.zero_sign_button) {
            addSymbol("0");
        } else if (v.getId() == R.id.subtract_button) {
            useAction();
            action = Action.SUBTRACT;
            numb = "";
            checkClicked(action);
        } else if (v.getId() == R.id.divide_button) {
            useAction();
            action = Action.DIVIDE;
            numb = "";
            checkClicked(action);
        } else if (v.getId() == R.id.multiple_button) {
            useAction();
            action = Action.MULTIPLE;
            numb = "";
            checkClicked(action);
        } else if (v.getId() == R.id.sum_button) {
            useAction();
            action = Action.SUM;
            numb = "";
            checkClicked(action);
        } else if (v.getId() == R.id.percent_button) {
            if (res != 0) {
                res *= 0.01;
                a = res;
                if (String.valueOf(res).charAt(String.valueOf(res).length() - 1) == '0') {
                    String result = String.valueOf(res).substring(0, String.valueOf(res).length() - 2);
                    resTextView.setText(result);
                } else resTextView.setText(String.valueOf(res));
                numb = String.valueOf(res);
            }
            else numb = String.valueOf(Float.parseFloat(numb) * 0.01);
            resTextView.setText(numb);
        } else if (v.getId() == R.id.dot_button) {
            for (int i = 0; i < numb.length(); i++)
                if (numb.charAt(i) == '.')
                    return;
            addSymbol(".");
        } else if (v.getId() == R.id.plus_minus_button) {
            if (res != 0) numb = String.valueOf(res);
            if (!Objects.equals(numb, ""))
                res = Float.parseFloat(numb) * -1;
            a = res;
            numb = String.valueOf(res);
            resTextView.setText(numb);
        } else if (v.getId() == R.id.equal_button) {
            equal(action);
            // if you want , after equal could be result that was before
            // action = Action.NULLACTION;
        } else if (v.getId() == R.id.delete_res_button) {
            resTextView.setText(R.string.zero_sign);
            action = Action.NULLACTION;
            numb = "";
            a = 0;
            b = 0;
            res = 0;
        }

//        Toast.makeText(getApplicationContext(), "a, b = " + a + " " + b, Toast.LENGTH_SHORT).show();
    }

    private void checkClicked(Action action) {
        subtract_button.setEnabled(true);
        divide_button.setEnabled(true);
        multiple_sign_button.setEnabled(true);
        sum_button.setEnabled(true);

        subtract_button.setTextColor(colorWhite);
        divide_button.setTextColor(colorWhite);
        multiple_sign_button.setTextColor(colorWhite);
        sum_button.setTextColor(colorWhite);

        switch (action) {
            case SUBTRACT:
                subtract_button.setEnabled(false);
                subtract_button.setTextColor(colorOrange);
                break;
            case SUM:
                sum_button.setEnabled(false);
                sum_button.setTextColor(colorOrange);
                break;
            case DIVIDE:
                divide_button.setEnabled(false);
                divide_button.setTextColor(colorOrange);
                break;
            case MULTIPLE:
                multiple_sign_button.setEnabled(false);
                multiple_sign_button.setTextColor(colorOrange);
                break;
            default:
                return;
        }
    }
    private void addSymbol(String sym) {
        if (numb.length() < 10) {
            numb += sym;
            resTextView.setText(numb);
        }
    }

    private void useAction() {
        if (!Objects.equals(numb, ""))
            a = Float.parseFloat(numb);
    }
    private enum Action {
        SUBTRACT,
        SUM,
        DIVIDE,
        MULTIPLE,
        NULLACTION
    }

    private float subtract(float a, float b) { return (float) a - b; }

    private float sum(float a, float b) { return (float) a + b; }

    private float divide(float a, float b) { return (float) a / b; }

    private float multiple(float a, float b) { return (float) a * b; }

    private void equal(Action action) {
//        checkAction();

        if (!Objects.equals(numb, ""))
            b = Float.parseFloat(numb);

        switch (action) {
            case SUBTRACT:
                res = subtract(a, b);
                subtract_button.setEnabled(true);
                subtract_button.setTextColor(colorOrange);
                break;
            case SUM:
                res = sum(a, b);
                sum_button.setEnabled(true);
                sum_button.setTextColor(colorOrange);
                break;
            case DIVIDE:
                res = divide(a, b);
                divide_button.setEnabled(true);
                divide_button.setTextColor(colorOrange);
                break;
            case MULTIPLE:
                res = multiple(a, b);
                multiple_sign_button.setEnabled(true);
                multiple_sign_button.setTextColor(colorOrange);
                break;
            case NULLACTION:
                break;
        }
        numb = "";
        a = res;
        if (String.valueOf(res).charAt(String.valueOf(res).length() - 1) == '0') {
            String result = String.valueOf(res).substring(0, String.valueOf(res).length() - 2);
            resTextView.setText(result);
        } else resTextView.setText(String.valueOf(res));
    }
}