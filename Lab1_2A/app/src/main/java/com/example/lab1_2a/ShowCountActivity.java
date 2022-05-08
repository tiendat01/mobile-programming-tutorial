package com.example.lab1_2a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowCountActivity extends AppCompatActivity {

    private TextView txtShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_count);

        Intent intent = getIntent(); // from parent MainActivity
        String display = intent.getStringExtra(MainActivity.EXTRA_KEY);
        txtShowCount = (TextView) findViewById(R.id.txtShowCount);
        txtShowCount.setText(display);

    }
}