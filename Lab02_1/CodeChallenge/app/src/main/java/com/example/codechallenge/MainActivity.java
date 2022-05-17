package com.example.codechallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;

    public static final String EXTRA_TEXT = "com.example.codechallenge.extra.TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) this.findViewById(R.id.btn1);
        btn2 = (Button) this.findViewById(R.id.btn2);
        btn3 = (Button) this.findViewById(R.id.btn3);

        Intent intent = new Intent(this, SecondActivity.class);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra(EXTRA_TEXT, getString(R.string.display_one));
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra(EXTRA_TEXT, getString(R.string.display_two));
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra(EXTRA_TEXT, getString(R.string.display_three));
                startActivity(intent);
            }
        });

    }

    // cach 2: onclick attribute (deprecated)
    public void showText(View view) {
        Intent intent = new Intent(this, SecondActivity.class);

//        insert some random text; got from randomtextgenerator.com
        switch (view.getId()){
            case R.id.btn1:
                intent.putExtra(EXTRA_TEXT, getString(R.string.display_one)); startActivity(intent);
                break;
            case R.id.btn2:
                intent.putExtra(EXTRA_TEXT, getString(R.string.display_two)); startActivity(intent);
                break;
            case R.id.btn3:
                intent.putExtra(EXTRA_TEXT, getString(R.string.display_three)); startActivity(intent);
                break;
            default:
                Toast.makeText(MainActivity.this, "There was an error", Toast.LENGTH_LONG).show();
                break;
        }
    }

}