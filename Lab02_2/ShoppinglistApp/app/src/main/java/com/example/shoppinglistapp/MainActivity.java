package com.example.shoppinglistapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1; // request code
    private static final String ARRAYLIST_KEY = "key to pack itemStringArray";

    private final TextView[] textViews = new TextView[10];
    private ArrayList<String> itemStringArray = new ArrayList<>(10);

    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inflate with gui
        textViews[0] = (TextView) findViewById(R.id.txtItem1);
        textViews[1] = (TextView) findViewById(R.id.txtItem2);
        textViews[2] = (TextView) findViewById(R.id.txtItem3);
        textViews[3] = (TextView) findViewById(R.id.txtItem4);
        textViews[4] = (TextView) findViewById(R.id.txtItem5);
        textViews[5] = (TextView) findViewById(R.id.txtItem6);
        textViews[6] = (TextView) findViewById(R.id.txtItem7);
        textViews[7] = (TextView) findViewById(R.id.txtItem8);
        textViews[8] = (TextView) findViewById(R.id.txtItem9);
        textViews[9] = (TextView) findViewById(R.id.txtItem10);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        // restore state
        if (savedInstanceState != null) {
            itemStringArray = savedInstanceState.getStringArrayList(ARRAYLIST_KEY);
            if (itemStringArray != null && itemStringArray.size() > 0){
                // render textview
                for (int i = 0; i < itemStringArray.size(); i++) {
                    if (itemStringArray.size() > 10) {
                        Toast.makeText(MainActivity.this, "Cannot add more item to the list.", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    textViews[i].setText(itemStringArray.get(i));
                    textViews[i].setVisibility(View.VISIBLE);
                }
            }
        }


    }

    // save state
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        if (itemStringArray != null && itemStringArray.size() > 0) {
            outState.putStringArrayList(ARRAYLIST_KEY, itemStringArray);
        }
    }

    // handle info from SecondActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {

                String itemString = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                if (itemString != null) {
                    itemStringArray.add(itemString);
                }
                // render textview
                for (int i = 0; i < itemStringArray.size(); i++) {
                    if (itemStringArray.size() > 10) {
                        Toast.makeText(MainActivity.this, "Cannot add more item to the list.", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    textViews[i].setText(itemStringArray.get(i));
                    textViews[i].setVisibility(View.VISIBLE);
                }
            }
        }
    }
}