//package com.example.lab1_2b;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.TextView;
//import android.widget.Toast;
//
//public class MainActivity extends AppCompatActivity {
//
//    private int mCount = 0;
//    private TextView textViewCount;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        textViewCount = (TextView) findViewById(R.id.show_count);
//    }
//
//    public void showToast(View view) {
//        Toast toast = Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT);
//        toast.show();
//    }
//
//    public void countUp(View view) {
//        mCount++;
//        if (textViewCount != null) {
//            textViewCount.setText(Integer.toString(mCount));
//        }
//    }
//
//    public void resetZero(View view) {
//    }
//}


package com.example.lab1_2b;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView textViewCount;
    private Button resetButton;
    private Button countButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homework_layout);

        textViewCount = (TextView) findViewById(R.id.show_count1);
        resetButton = (Button) findViewById(R.id.button_zero); resetButton.setClickable(false);
        countButton = (Button) findViewById(R.id.button_count1);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        if (textViewCount != null) {
            textViewCount.setText(String.format(Locale.ENGLISH, "%d", mCount));
        }

        resetButton.setBackgroundColor(getColor(R.color.zero_enable_color));
        resetButton.setClickable(true);

        switch (mCount % 2){
            case 0:
                view.setBackgroundColor(Color.parseColor("#09FF09"));
                break;
            case 1:
                view.setBackgroundColor(Color.RED);
                break;
            default:
                break;
        }
    }

    @SuppressLint("ResourceAsColor")
    public void resetZero(View view) {
        if (mCount != 0){
            mCount = 0;
            textViewCount.setText(Integer.toString(mCount));


            view.setBackgroundColor(getColor(R.color.zero_disable_color));

            countButton.setBackgroundColor(R.color.count_empty_color);
        }
        view.setClickable(false);

    }
}