package com.example.lab4_2_droidcafeinput;

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

    private StringBuilder orderMessage = new StringBuilder("");
    public static final String EXTRA_MESSSAGE = "ORDER_MESSAGE";

    private FloatingActionButton floatingActionButton = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        donutImgView = findViewById(R.id.donut);
        donutImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderMessage.append(getString(R.string.donut_order_message)).append('\n');
                displayToastMsg(getString(R.string.donut_order_message));
            }
        });

        iceImgView = findViewById(R.id.ice_cream);
        iceImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderMessage.append(getString(R.string.ice_cream_order_message)).append('\n');
                //displayToastMsg(getString(R.string.ice_cream_order_message));
                displayToastMsg(getText(R.string.ice_cream_order_message).toString());
            }
        });

        froyoImgView = findViewById(R.id.froyo);
        froyoImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderMessage.append(getString(R.string.froyo_order_message)).append('\n');
                displayToastMsg(getString(R.string.froyo_order_message));
            }
        });

        floatingActionButton = findViewById(R.id.btnOrder);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_MESSSAGE, orderMessage.toString());
                startActivity(intent);
            }
        });
    }

    public void displayToastMsg(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

    }
}