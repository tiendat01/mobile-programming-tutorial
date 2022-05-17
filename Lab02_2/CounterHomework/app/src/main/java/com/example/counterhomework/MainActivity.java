package com.example.counterhomework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtCount = null;
    private Button btnCount = null;
    private Integer count = null;

    public static final String KEY_SAVE_STATE = "countState";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCount = findViewById(R.id.txtCount);
        btnCount = findViewById(R.id.btnCount);

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                txtCount.setText(String.valueOf(count));
            }
        });

        // restore state
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(KEY_SAVE_STATE);
        }
    }

    
    // save state for textview
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        if (count != null) {
            outState.putInt(KEY_SAVE_STATE, count);
        }
    }
}