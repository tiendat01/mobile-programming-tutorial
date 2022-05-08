package com.example.codechallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView txtDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtDisplay = (TextView) this.findViewById(R.id.txtDisplay);

        Intent intent = getIntent();
        String display = intent.getStringExtra(MainActivity.EXTRA_TEXT);
        txtDisplay.setText(display);
    }
}