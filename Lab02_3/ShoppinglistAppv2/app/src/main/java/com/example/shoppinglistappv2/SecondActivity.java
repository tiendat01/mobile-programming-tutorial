package com.example.shoppinglistappv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.shoppinglist.EXTRA_REPLY";
    private final Button[] buttons = new Button[11];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // inflate gui
        buttons[0] = (Button) findViewById(R.id.button1);
        buttons[1] = (Button) findViewById(R.id.button2);
        buttons[2] = (Button) findViewById(R.id.button3);
        buttons[3] = (Button) findViewById(R.id.button4);
        buttons[4] = (Button) findViewById(R.id.button5);
        buttons[5] = (Button) findViewById(R.id.button6);
        buttons[6] = (Button) findViewById(R.id.button7);
        buttons[7] = (Button) findViewById(R.id.button8);
        buttons[8] = (Button) findViewById(R.id.button9);
        buttons[9] = (Button) findViewById(R.id.button10);
        buttons[10] = (Button) findViewById(R.id.button11);


        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button tmp = (Button) view;
                    Intent returnIntent = new Intent(SecondActivity.this, MainActivity.class);
                    returnIntent.putExtra(EXTRA_REPLY, tmp.getText().toString());
                    setResult(RESULT_OK, returnIntent);
                    finish();
                }
            });
        }

    }


    // Cach 2: use attribute android:onclick with the only one method
    public void addItem(View view) {
        switch (view.getId()) {
            case R.id.button1:
                // ...
        }
    }
}