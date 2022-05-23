package com.example.lab4_1_droidcafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    private TextView txtOrder = null;
    private StringBuilder orderMsg = new StringBuilder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


        // receive msg from MainActivity
        Intent intent = getIntent();
        orderMsg.append(intent.getStringExtra(MainActivity.EXTRA_MESSSAGE));
        txtOrder = findViewById(R.id.txtOrder);
        txtOrder.setText(orderMsg);

    }

}