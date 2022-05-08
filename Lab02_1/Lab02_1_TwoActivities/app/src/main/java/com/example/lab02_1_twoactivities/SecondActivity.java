package com.example.lab02_1_twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView txtMessage;
    private EditText editReply;

    public static final String EXTRA_REPLY =
            "com.example.lab02_1_twoactivities.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Receive message from main activity
        Intent intent = getIntent(); // from parent activity
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //        int count = intent.getIntExtra("count", 0);

        txtMessage = (TextView) this.findViewById(R.id.txtMessage);
        txtMessage.setText(message);

        // Reply
        editReply = (EditText) findViewById(R.id.editReply);

    }

    // Cach 2 to set behavior for button : android:onClick="returnReply" (deprecated)
    public void returnReply(View view) {
        String reply = editReply.getText().toString();
        Intent replyIntent = new Intent(SecondActivity.this, MainActivity.class);
        replyIntent.putExtra(EXTRA_REPLY, reply);
        // return data to parent MainActivity
        setResult(RESULT_OK, replyIntent); // Set the result to RESULT_OK / RESULT_CANCALLED to indicate that the response was successful.
        finish(); // close the Activity and return to MainActivity
    }
}