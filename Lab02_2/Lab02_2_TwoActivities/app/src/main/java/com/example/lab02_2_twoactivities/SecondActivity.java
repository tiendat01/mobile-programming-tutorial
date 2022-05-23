package com.example.lab02_2_twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String LOG_TAG = SecondActivity.class.getSimpleName();

    private TextView txtMessage;
    private EditText editReply;

    public static final String EXTRA_REPLY = "com.example.lab02_2_twoactivities.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Receive message from main activity
        // intent start SecondActivity from MainActivity and its extras data autosaved by Android System
        Intent intent = getIntent(); // from parent activity
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //        int count = intent.getIntExtra("count", 0);

        txtMessage = (TextView) this.findViewById(R.id.txtMessage);
        txtMessage.setText(message);

        // Reply
        editReply = (EditText) findViewById(R.id.editReply);


        // logging:
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "State: onCreate");
    }

    // Cach 2 to set behavior for button : android:onClick="returnReply" (deprecated)
    public void returnReply(View view) {
        String reply = editReply.getText().toString();
        Intent replyIntent = new Intent(SecondActivity.this, MainActivity.class);
        replyIntent.putExtra(EXTRA_REPLY, reply);
        // return data to parent MainActivity
        setResult(RESULT_OK, replyIntent); // Set the result to RESULT_OK / RESULT_CANCALLED to indicate that the response was successful.

        Log.d(LOG_TAG, "End SecondActivity");

        finish(); // close the Activity and return to MainActivity
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "State: onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "State: onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "State: onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "State: onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "State: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "State: onĐistroy");
    }

}