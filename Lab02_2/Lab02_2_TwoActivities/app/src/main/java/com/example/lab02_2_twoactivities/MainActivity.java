package com.example.lab02_2_twoactivities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnSend;
    private EditText editMessage;

    private TextView txtReply;
    private TextView txtHeader;

    // key for logging
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    // key for put string extra to intent
    public static final String EXTRA_MESSAGE = "com.example.lab02_2_twoactivities.extra.MESSAGE";
    // request code to startActivityForResult
    private static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = (Button) this.findViewById(R.id.btnSend);
        // Cach 1 to set behavior of button
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(LOG_TAG, "Button Send of MainActivity clicked!");
                // call explicit intent (know the class name - target of intent
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                String message = editMessage.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, message); // name - value
                //        intent.putExtra("count", 10);

                //        Bundle bundle = new Bundle();
                //        bundle.putFloat(); // dong goi nhieu cac kieu du lieu vao bundle voi cung 1 key
                //        intent.putExtra("bundle", new Bundle());

//                startActivity(intent); // not need to get data back
                startActivityForResult(intent, TEXT_REQUEST); // start Activity and wait for result data from SecondActivity
            }
        });

        editMessage = (EditText) this.findViewById(R.id.editMessage);
        txtReply = (TextView) this.findViewById(R.id.txtReply);
        txtHeader = (TextView) this.findViewById(R.id.txtHeader);

        // restore the state
        // See onSaveInstanceState() for what gets saved.
        if (savedInstanceState != null) {
            boolean isVisible = savedInstanceState.getBoolean("txtHeader_reply_visible");
            if (isVisible) {
                txtHeader.setVisibility(View.VISIBLE);

                txtReply.setText(savedInstanceState.getString("txtReply_reply_content"));
                txtReply.setVisibility(View.VISIBLE);
            }
        }

        // logging:
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "State: onCreate");
    }

    // save states of activity to outState when the activity is destroyed: about 3-4 trang thai
    // be called between onPause() and onStop().
    // viec save co the viet trong ham onPause() or onStop(), khi do ko co bien outState de save, ta phai tu save vao file nao do
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        if (txtHeader.getVisibility() == View.VISIBLE) {
            outState.putBoolean("txtHeader_reply_visible", true);
            outState.putString("txtReply_reply_content", txtReply.getText().toString());
        }

    }


    // callback method to handle with return data from intent request
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // three parameters contain information to handle return data:
        // requestCode when you launched the SecondActivity with startActivityForResult()
        // resultCode (usually RESULT_OK or RESULT_CANCELLED or RESULT_FIRST_USER) from setResult() in SecondActivity
        // data intent contains data returned from the launch SecondActivity
        super.onActivityResult(requestCode, resultCode, data);

        // handle the response for request whose requestCode == TEXT_REQUEST
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                txtHeader.setVisibility(View.VISIBLE);
                txtReply.setText(reply);
                txtReply.setVisibility(View.VISIBLE);

            }
        }
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