package com.example.lab1_2a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;

    private Button myButt;
    private Toast myToast;

    public static final String EXTRA_KEY = "com.example.lab1_2a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.rotate_main);
//        setContentView(R.layout.activity_test);
        mShowCount = (TextView) this.findViewById(R.id.show_count); // TextView dynamic

        // add button by Java code
//        myButt = new Button(this);
//        myButt.setText("This butt added by Java");
//        myButt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                myToast = Toast.makeText(MainActivity.this, "My custom Toast", Toast.LENGTH_SHORT);
//                myToast.show();
//            }
//        });
//        ConstraintLayout mainLayout = findViewById(R.id.layout);
//        mainLayout.addView(myButt); // add button to layout
    }

    public void showToast(View view) {
        // Toast la doi tuong cho cac thong bao nho hien thi tren man hinh
        Toast toast = Toast.makeText(this,
                R.string.toast_message, Toast.LENGTH_SHORT); // 2s for short Toast, 3.5s for long Toast
        toast.show();
    }

    public void countUp(View view) {
        this.mCount++;
        if (this.mShowCount != null) {
            this.mShowCount.setText(Integer.toString(this.mCount));
        }
    }

    public void sayHello(View view) {
        Intent intent = new Intent(MainActivity.this, ShowCountActivity.class);
        String display = "Hello!\n" + Integer.toString(this.mCount);
        intent.putExtra(EXTRA_KEY, display);
        startActivity(intent);
    }
}