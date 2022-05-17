package com.example.lab4_1_droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private ImageView donutImgView = null;
    private ImageView iceImgView = null;
    private ImageView froyoImgView = null;

    private FloatingActionButton floatingActionButton = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        donutImgView = findViewById(R.id.donut);
        donutImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayToastMsg(getString(R.string.donut_order_message));
            }
        });

        iceImgView = findViewById(R.id.ice_cream);
        iceImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayToastMsg(getString(R.string.ice_cream_order_message));
            }
        });

        froyoImgView = findViewById(R.id.froyo);
        froyoImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayToastMsg(getString(R.string.froyo_order_message));
            }
        });

        floatingActionButton = findViewById(R.id.btnOrder);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });
    }

    public void displayToastMsg(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

    }
}