package com.example.lab1_2a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.rotate_main);
        mShowCount = (TextView) this.findViewById(R.id.show_count); // TextView dynamic
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
}